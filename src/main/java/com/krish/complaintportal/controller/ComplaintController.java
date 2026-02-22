package com.krish.complaintportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;
import com.krish.complaintportal.model.Complaint;
import com.krish.complaintportal.model.User;
import com.krish.complaintportal.repository.UserRepository;
import com.krish.complaintportal.service.ComplaintService;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {
    private final ComplaintService complaintService;
    private final UserRepository userRepository;

    public ComplaintController(ComplaintService complaintService, UserRepository userRepository) {
        this.complaintService = complaintService;
        this.userRepository = userRepository;
    }

    @GetMapping("/my-complaints")
    public String redirectMyComplaints() {
        return "redirect:/complaints/my";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "create-complaint";
    }
    @PostMapping("/create")
    public String createComplaint(@ModelAttribute Complaint complaint, Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        complaint.setUser(user);
        complaintService.saveComplaint(complaint);
        return "redirect:/complaints/my";
    }
    @GetMapping("/my")
    public String myComplaints(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("complaints", complaintService.getUserComplaints(user));
        return "my-complaints";
    }
}

