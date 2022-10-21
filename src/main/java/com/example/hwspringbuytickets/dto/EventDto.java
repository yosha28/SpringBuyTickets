package com.example.hwspringbuytickets.dto;

import com.example.hwspringbuytickets.model.Place;
import com.example.hwspringbuytickets.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;

    private String  name;

    private Date date;

    private List<TicketDto> tickets;

  // private Place place;
}
