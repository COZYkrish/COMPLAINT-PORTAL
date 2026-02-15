package com.krish.complaintportal.controller;

import com.krish.complaintportal.repository.UserRepository;
import com.krish.complaintportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "Email not registered!");
            return "login";
        }

        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid password!");
            return "login";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
