package com.soa_.ManageFootballStadium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/stadium")
    public String stadium() {
        return "stadium";
    }

    @GetMapping("/review")
    public String review() {
        return "review";
    }

    @GetMapping("/checkReview")
    public String checkReview() {
        return "checkreview";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "adminbooking";
    }

    @GetMapping("/admin/chart")
    public String adminChart() {
        return "adminchart";
    }
}
