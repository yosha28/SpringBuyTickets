package com.example.hwspringbuytickets.controller;

import com.example.hwspringbuytickets.dto.EventDto;
import com.example.hwspringbuytickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //RestController returns json
public class IndexController {



//    @GetMapping("/")
//    public String helloPage(Model model){
//      //  model.addAttribute("testMsg","Hello from server");
//        return "index";
//    }

//    @GetMapping("world1")
//    public String worldPageDate(Model model){
//        model.addAttribute("testMsg","Hello from world");
//        //  var event=new EventDto();
//        var events=eventService.getFullList();
//        model.addAttribute("event",events);
//        return "data/world";
//    }
}
