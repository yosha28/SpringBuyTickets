package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.entity.Role;
import com.example.hwspringbuytickets.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
//@Transactional
    public void createRole()
    {
        Role r1 = new Role();
        r1.setRoleName("ROLE_ADMIN");
       roleRepository.save(r1);

        Role r2 = new Role();
        r2.setRoleName("ROLE_USER");
        roleRepository.save(r2);

        roleRepository.flush();
    }


}
