package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.dto.CustomerDto;
import com.example.hwspringbuytickets.dto.EventDto;
import com.example.hwspringbuytickets.dto.TicketDto;
import com.example.hwspringbuytickets.dto.TicketPackDto;
import com.example.hwspringbuytickets.entity.Customer;
import com.example.hwspringbuytickets.entity.Event;
import com.example.hwspringbuytickets.entity.Ticket;
import com.example.hwspringbuytickets.entity.TicketStatus;
import com.example.hwspringbuytickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class TicketService {
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;

    public void saveTicket(TicketDto dto) {
        Ticket ticket = modelMapper.map(dto, Ticket.class);
        ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketListForEvent(List<TicketPackDto> packDto) {
        List<Ticket> ticketList = new ArrayList<>();
        packDto.forEach(t ->
        {//новая цена-новый отсчет мест
            for (int i = 1; i < t.getCount() + 1; i++) {
                Ticket ticket = modelMapper.map(TicketDto.builder()
                        .cost(t.getCost())
                        .number(i)
                        .status(TicketStatus.FREE)
                        .build(), Ticket.class);

                ticketList.add(ticket);
                ticketRepository.save(ticket);

            }

        });
        return ticketList;

    }

    public List<TicketDto> getListFreeTicketFromEvent(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        return ticketRepository.getFreeTicket(event).stream()
                .map(t -> modelMapper.map(t, TicketDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void buyTicket(Long id, CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        ticketRepository.buyTicket(id, customer);
    }
}
