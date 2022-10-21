package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.dto.PlaceDto;
import com.example.hwspringbuytickets.model.Place;
import com.example.hwspringbuytickets.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlaceService {
    private final ModelMapper appModelMapper;
    private final PlaceRepository placeRepository;

    public void save(PlaceDto placeDto) {
       Place place = appModelMapper.map(placeDto, Place.class);
        placeRepository.save(place);
    }

    public Place getForName(String name)
    {
        return placeRepository.findForName(name);
    }

    public List<PlaceDto> getAll()
    {
        return placeRepository.findAll().stream()
                .map(placeEntity -> appModelMapper.map(placeEntity, PlaceDto.class))
                .collect(Collectors.toList());
    }
    public boolean existsPlace(PlaceDto dto)
    {
        if(placeRepository.findForName(dto.getName())==null)
        {
           return false;
        }
        return true;
    }
}
