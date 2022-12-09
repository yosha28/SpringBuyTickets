package com.example.hwspringbuytickets.repository;

import com.example.hwspringbuytickets.entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    @Override
    List<Event> findAll();

    @Query("from Event where date>= :dateNow")
    List<Event> getPossibleEvent(Date dateNow);

    @Query("from Event where date= :date and name= :name")
    Event getEventFromNameDate(Date date, String name);

}
