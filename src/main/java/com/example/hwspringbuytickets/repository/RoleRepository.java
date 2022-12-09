package com.example.hwspringbuytickets.repository;

import com.example.hwspringbuytickets.entity.Place;
import com.example.hwspringbuytickets.entity.Role;
import com.example.hwspringbuytickets.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
//@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("from Role  where roleName = ?1")
   Role findRole(String roleName);

    @Override
    List<Role> findAll();
}
