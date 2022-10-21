package com.example.hwspringbuytickets.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreationDto {
    private  Long id;
    private Date date;
    private String name;
    private List<TicketPackDto> ticketPack;
    private PlaceDto place;


    public EventCreationDto(Date event_date, String name, List<TicketPackDto> ticketPack, PlaceDto place) {
        this.date = event_date;
        this.name = name;
        this.ticketPack = ticketPack;
        this.place = place;
    }

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

    public List<TicketPackDto> getTicketPack() {
        return ticketPack;
    }

    public void setTicketPack(List<TicketPackDto> ticketPack) {
        this.ticketPack = ticketPack;
    }

    public PlaceDto getPlace() {
        return place;
    }

    public void setPlace(PlaceDto place) {
        this.place = place;
    }
}
