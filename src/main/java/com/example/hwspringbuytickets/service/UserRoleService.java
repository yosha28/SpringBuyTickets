package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.entity.Customer;
import com.example.hwspringbuytickets.entity.Event;
import com.example.hwspringbuytickets.entity.Role;
import com.example.hwspringbuytickets.entity.UserRole;
import com.example.hwspringbuytickets.repository.RoleRepository;
import com.example.hwspringbuytickets.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final RoleRepository roleRepository;


    public void saveUserRole(Customer customer) {

        UserRole userRole = new UserRole();
        userRole.setCustomer(customer);

     //   roleService.createRole();

        userRole.setRole(roleRepository.findRole("ROLE_USER"));
        userRoleRepository.save(userRole);

    }

}