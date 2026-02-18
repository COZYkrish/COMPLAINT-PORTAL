package com.krish.complaintportal.controller;

import com.krish.complaintportal.model.User;
import com.krish.complaintportal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final UserService userService;

    // Constructor Injection
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/my-complaints")
    public String redirectMyComplaints() {
        return "redirect:/complaints/my";
    }
}
