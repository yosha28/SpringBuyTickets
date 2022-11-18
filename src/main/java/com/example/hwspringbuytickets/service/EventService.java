package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.dto.EventCreationDto;
import com.example.hwspringbuytickets.dto.EventDto;
import com.example.hwspringbuytickets.dto.PlaceDto;
import com.example.hwspringbuytickets.dto.TicketDto;
import com.example.hwspringbuytickets.model.Event;
import com.example.hwspringbuytickets.model.Place;
import com.example.hwspringbuytickets.model.Ticket;
import com.example.hwspringbuytickets.model.TicketStatus;
import com.example.hwspringbuytickets.repository.EventRepository;
import com.example.hwspringbuytickets.repository.PlaceRepository;
import com.example.hwspringbuytickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventService {
    private final ModelMapper modelMapper;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final TicketService ticketService;
    private final PlaceRepository placeRepository;
    private final PlaceService placeService;

    @Transactional
    public void saveEvent(EventCreationDto dto) {
        EventDto eventDto = modelMapper.map(dto, EventDto.class);

        Event event = modelMapper.map(eventDto, Event.class);
        eventRepository.save(event);

        Place place = placeRepository.findForName(dto.getPlace().getName());
//в один день тот же ивент может быть в разных местах, иначе нужно добавить в constraint unique name
        if (place != null) {
            event.setPlace(place);
        } else {
            place = modelMapper.map(dto.getPlace(), Place.class);
            event.setPlace(place);
        }

        List<Ticket> ticketList = ticketService.getTicketListForEvent(dto.getTicketPack());

        ticketList.forEach(t -> {
            t.setEvent(event);
        });
        event.setTickets(ticketList);

        eventRepository.save(event);

    }

    @Transactional
    public List<EventDto> getFullList() {
        return eventRepository.findAll().stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }

    public List<EventDto> getListPossibleEvent(Date date) {
        return eventRepository.getPossibleEvent(date).stream()
                .map(e -> modelMapper.map(e, EventDto.class))
                .collect(Collectors.toList());
    }

    public EventDto getCurrentEvent(Date date, String name) {
        Event event = eventRepository.getEventFromNameDate(date, name);
        if (event != null) {
            return modelMapper.map(event, EventDto.class);
        }
        return null;
    }

}
