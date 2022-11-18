package com.example.hwspringbuytickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {

    @GetMapping("/")
    public String indexPage(Model model) {

        return "index";
    }

}
