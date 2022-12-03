package com.example.hwspringbuytickets.controller;

import com.example.hwspringbuytickets.dto.*;
import com.example.hwspringbuytickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private EventService eventService;
    @GetMapping("test")
    public String helloPage(Model model) {
        model.addAttribute("testMsg", "Hello from server");
        model.addAttribute("time", System.currentTimeMillis());

        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title 1", "body qwerrtrtuy1"));
        posts.add(new Post("title 2", "body qwerrtrtuy2"));
        posts.add(new Post("title 3", "body qwerrtrtuy3"));
        model.addAttribute("testPosts", posts);

        model.addAttribute("status", Status.BAD.toString());
     //   model.addAttribute("status", Status.NEW.toString());

        return "test";
    }
    @GetMapping("world")
    // == @RequestMapping(value="world",method= RequestMethod.GET)
    public String worldPage(Model model) {
        model.addAttribute("testMsg","Hello from world");
        //  var event=new EventDto();
        List<TicketPackDto> tickets = new ArrayList<TicketPackDto>();
        tickets.add(TicketPackDto.builder().cost(100).count(1).build());
        tickets.add(TicketPackDto.builder().cost(200).count(2).build());
        createEvent();

        var event=eventService.getFullList().get(0);
        model.addAttribute("event",event);
        var events=eventService.getFullList();
        model.addAttribute("events",events);

        return "data/world";
    }

public void createEvent() /*throws java.text.ParseException*/ {
        List<TicketPackDto> tickets = new ArrayList<TicketPackDto>();
        tickets.add(TicketPackDto.builder().cost(100).count(1).build());
        tickets.add(TicketPackDto.builder().cost(200).count(2).build());

        EventCreationDto dto = new EventCreationDto();
      //  dto.setEvent_date(format.parse("2022-12-29"));
        dto.setName("Event 7");
        PlaceDto placeDto = PlaceDto.builder().address("str.First").name("ConcertHall 7").build();
        dto.setPlace(placeDto);
        dto.setTicketPack(tickets);

        eventService.saveEvent(dto);
    }
}
