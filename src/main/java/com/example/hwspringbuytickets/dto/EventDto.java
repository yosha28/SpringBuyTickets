package com.example.hwspringbuytickets.dto;

import com.example.hwspringbuytickets.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;

    private String  name;

    private Date date;

    private List<TicketDto> ticketPack;

   private PlaceDto place;

        public Date getEvent_date() {
        return date;
    }

    public void setEvent_date(Date event_date) {
        this.date = event_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TicketDto> getTicketPack() {
        return ticketPack;
    }

    public void setTicketPack(List<TicketDto> ticketPack) {
        this.ticketPack = ticketPack;
    }

    public PlaceDto getPlace() {
        return place;
    }

    public void setPlace(PlaceDto place) {
        this.place = place;
    }

}
