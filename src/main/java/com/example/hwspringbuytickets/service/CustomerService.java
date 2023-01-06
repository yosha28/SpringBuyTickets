package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.dto.CustomerDto;
import com.example.hwspringbuytickets.entity.Customer;
import com.example.hwspringbuytickets.repository.CustomerRepository;
import com.example.hwspringbuytickets.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerService implements UserDetailsService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRoleService userRoleService;


    @Transactional
    public boolean saveCustomer(CustomerDto dto) {
        Customer customer = mapper.map(dto, Customer.class);
        CustomerDto customerBd = getCustomerForEmail(dto.getEmail());
        if (customerBd != null) return false;
        log.info("Save User: " + customer);
        customerRepository.save(customer);
        // customerRepository.flush();
        Customer cust = this.customerRepository.findUserAccount(dto.getEmail())
                .orElseThrow(RuntimeException::new);

        String admin1= "maya2882@gmail.com";
        log.info("EEEEEmail: " + dto.getEmail());
        if (dto.getEmail().equals(admin1)) userRoleService.saveAdminRole(cust);
        else userRoleService.saveUserRole(cust);

        return true;
    }

    public CustomerDto create(CustomerDto customerDto) {
        Customer entity = mapper.map(customerDto, Customer.class);
        customerRepository.save(entity);
        return mapper.map(entity, CustomerDto.class);
    }

    public CustomerDto findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(entity -> mapper.map(entity, CustomerDto.class)).orElse(null);
    }

    public CustomerDto getCustomerForEmail(String email) {
        Optional<Customer> customer = customerRepository.findUserAccount(email);
        return customer.map(entity -> mapper.map(entity, CustomerDto.class)).orElse(null);
        // return customer != null ? mapper.map(customer, CustomerDto.class) : null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Customer customer = this.customerRepository.findUserAccount(userEmail)
                .orElseThrow(RuntimeException::new);

        //    userRoleService.saveUserRole(customer);

        log.info(" in loadUserBy ");
        if (customer == null) {
            log.error("User not found! " + userEmail);
            throw new UsernameNotFoundException("User " + userEmail + " was not found in the database");
        }

        log.info("Found User: " + customer);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.userRoleRepository.getRoleNames(customer.getId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            grantList = roleNames.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        return new User(customer.getEmail(), customer.getEncrytedPassword(), grantList);
    }


}
