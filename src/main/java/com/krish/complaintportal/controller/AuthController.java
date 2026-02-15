package com.krish.complaintportal.controller;

import com.krish.complaintportal.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

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
        Model model,
        HttpSession session) {

    User user = userRepository.findByEmail(email);

    if (user == null) {
        model.addAttribute("error", "Email not registered!");
        return "login";
    }

    if (!user.getPassword().equals(password)) {
        model.addAttribute("error", "Invalid password!");
        return "login";
    }

    session.setAttribute("loggedInUser", user);

    return "redirect:/dashboard";
}


    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "dashboard";
}

}
