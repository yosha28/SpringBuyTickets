package com.example.hwspringbuytickets.controller;

import com.example.hwspringbuytickets.dto.CustomerDto;
import com.example.hwspringbuytickets.dto.UserRoleDto;
import com.example.hwspringbuytickets.entity.Customer;
//import com.example.hwspringbuytickets.repository.UserRepository;
import com.example.hwspringbuytickets.entity.Role;
import com.example.hwspringbuytickets.entity.UserRole;
import com.example.hwspringbuytickets.repository.CustomerRepository;
import com.example.hwspringbuytickets.repository.RoleRepository;
import com.example.hwspringbuytickets.repository.UserRoleRepository;
import com.example.hwspringbuytickets.service.CustomerService;
import com.example.hwspringbuytickets.service.UserRoleService;
import com.example.hwspringbuytickets.utils.WebUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Log4j2
public class AuthController {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserRoleService userRoleService;


    @GetMapping(value = {"/welcome"})
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @GetMapping(value = "/admin")
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        return "loginPage";
    }

    @GetMapping(value = "/registration")
    public String registrationPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "registrationPage";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userEmail = principal.getName();


        System.out.println("User Name: " + userEmail);


        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

    @PostMapping("/saveRegistration")
    public String saveRegistration(@ModelAttribute("customer") CustomerDto customerDto, Model model) {
        log.info("go to Registr");
        //   CustomerDto userDto = new CustomerDto();

        //   userDto.setEmail(customerDto.getEmail());

        customerDto.setEncrytedPassword(encoder.encode(customerDto.getEncrytedPassword()));
        customerDto.setEnabled(true);

        if (!customerService.saveCustomer(customerDto)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registrationPage";
        }
        //  securityService.autoLogin(customerDto.getEmail(),customerDto.getEncrytedPassword());
        log.info("go to userRoleService");



        return "loginPage";
    }

}
