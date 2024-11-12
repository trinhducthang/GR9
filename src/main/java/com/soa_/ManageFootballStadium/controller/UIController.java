package com.soa_.ManageFootballStadium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/stadium")
    public String stadium() {
        return "stadium";
    }
}
