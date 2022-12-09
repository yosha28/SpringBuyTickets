package com.example.hwspringbuytickets.configuration;

import com.example.hwspringbuytickets.entity.Customer;
import com.example.hwspringbuytickets.entity.Role;
import com.example.hwspringbuytickets.entity.UserRole;
import com.example.hwspringbuytickets.repository.RoleRepository;
import com.example.hwspringbuytickets.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class DbInitConfig {

  //  private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DbInitConfig(
                        UserRoleRepository userRoleRepository,
                        RoleRepository roleRepository) {
      //  this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // инициализация начальных данных

//        Customer apu1 = new Customer();
//      //  apu1.setId(1L);
//        apu1.setName("admin");
//        apu1.setEncrytedPassword("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
//        apu1.setEnabled(true);
//        apu1 = userRepository.save(apu1);
//
//        Customer apu2 = new Customer();
//     //   apu2.setId(2L);
//        apu2.setName("user");
//        apu2.setEncrytedPassword("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
//        apu2.setEnabled(true);
//        apu2 = userRepository.save(apu2);
//        userRepository.flush();

//        Role r1 = new Role();
//        r1.setRoleId(1L);
//        r1.setRoleName("ROLE_ADMIN");
//        r1 = roleRepository.save(r1);
//
//        Role r2 = new Role();
//        r2.setRoleId(2L);
//        r2.setRoleName("ROLE_USER");
//        r2 = roleRepository.save(r2);
//
//        roleRepository.flush();

//        UserRole ur1 = new UserRole();
//        ur1.setId(1L);
//        ur1.setAppUser(apu1);
//        ur1.setRole(r1);
//        userRoleRepository.save(ur1);
//
//        UserRole ur2 = new UserRole();
//        ur2.setId(2L);
//        ur2.setAppUser(apu1);
//        ur2.setRole(r2);
//        userRoleRepository.save(ur2);
//
//        UserRole ur3 = new UserRole();
//        ur3.setId(3L);
//        ur3.setAppUser(apu2);
//        ur3.setRole(r2);
//        userRoleRepository.save(ur3);
    }
}
