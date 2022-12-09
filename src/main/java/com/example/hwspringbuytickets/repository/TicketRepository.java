package com.example.hwspringbuytickets.repository;

import com.example.hwspringbuytickets.entity.Customer;
import com.example.hwspringbuytickets.entity.Event;
import com.example.hwspringbuytickets.entity.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {
    @Override
    List<Ticket> findAll();

    @Query("from Ticket where status='FREE' and event = :event")
    List<Ticket> getFreeTicket(Event event);

    @Modifying
    @Query("update Ticket t set t.customer= :customer , t.status= 'SOLD' where t.id = :id")
    void buyTicket(Long id, Customer customer);

}
