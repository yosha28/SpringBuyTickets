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
public class IndexController {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/")
    public String indexPage(Model model) {

        return "index";
    }

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
    public String worldPage(Model model) throws java.text.ParseException {
        model.addAttribute("testMsg", "Hello from world");

      //  createEvent();

        var events = eventService.getFullList();
        model.addAttribute("events", events);

        return "data/world";
    }

    public void createEvent() throws java.text.ParseException {
        List<TicketPackDto> tickets = new ArrayList<TicketPackDto>();
        tickets.add(TicketPackDto.builder().cost(100).count(1).build());
        tickets.add(TicketPackDto.builder().cost(200).count(2).build());

        EventCreationDto dto = new EventCreationDto();
        dto.setEvent_date(format.parse("2022-12-29"));
        dto.setName("Event 1");
        PlaceDto placeDto = PlaceDto.builder().address("str.First").name("ConcertHall 7").build();
        dto.setPlace(placeDto);
        dto.setTicketPack(tickets);

        eventService.saveEvent(dto);

        List<TicketPackDto> tickets2 = new ArrayList<TicketPackDto>();
        tickets2.add(TicketPackDto.builder().cost(100).count(1).build());
        tickets2.add(TicketPackDto.builder().cost(200).count(2).build());

        EventCreationDto dto2 = new EventCreationDto();
        dto2.setEvent_date(format.parse("2022-12-30"));
        dto2.setName("Event 2");
        PlaceDto placeDto2 = PlaceDto.builder().address("str.Second").name("ConcertHall 2").build();
        dto2.setPlace(placeDto2);
        dto2.setTicketPack(tickets2);

        eventService.saveEvent(dto2);
    }
}
