package com.example.hwspringbuytickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {
    @GetMapping("/buy_ticket")
    public String indexPage(Model model) {

        return "data/buy_ticket";
    }
}
