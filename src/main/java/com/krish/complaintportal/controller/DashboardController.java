package com.krish.complaintportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {

        model.addAttribute("email", principal.getName());

        return "dashboard";
    }
}
