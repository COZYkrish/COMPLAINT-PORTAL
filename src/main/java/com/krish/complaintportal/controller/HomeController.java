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

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password) {

        User user = new User(name, email, password);
        userService.saveUser(user);

        return "redirect:/";
    }
}
