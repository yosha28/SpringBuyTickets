package com.example.hwspringbuytickets.repository;

import com.example.hwspringbuytickets.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("from Customer a where a.email = ?1")
    Optional<Customer> findUserAccount(String email);

}
