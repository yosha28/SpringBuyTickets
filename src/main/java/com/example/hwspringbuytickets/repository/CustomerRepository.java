package com.example.hwspringbuytickets.repository;

import com.example.hwspringbuytickets.model.Customer;
import com.example.hwspringbuytickets.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("from Customer where email= :email ")
    Customer getCustomerForEmail(String email);

}
