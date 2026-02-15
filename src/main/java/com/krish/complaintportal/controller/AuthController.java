package com.krish.complaintportal.controller;

import com.krish.complaintportal.repository.UserRepository;
import com.krish.complaintportal.model.User;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String email,
                               @RequestParam String password,
                               Model model) {

        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email already registered!");
            return "register";
        }
        User user = new User();
        user.setEmail(email);

        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return "redirect:/login";
    }

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
        if (!passwordEncoder.matches(password, user.getPassword())) {
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


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
