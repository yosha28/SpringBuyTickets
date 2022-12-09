package com.example.hwspringbuytickets.repository;

import com.example.hwspringbuytickets.entity.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository  extends CrudRepository<Place,Long> {
    @Override
    List<Place> findAll();

    @Query("from Place where name= :name ")
    Place findForName(String name);

}
