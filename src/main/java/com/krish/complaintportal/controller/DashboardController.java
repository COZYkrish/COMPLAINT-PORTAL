package com.krish.complaintportal.controller;


import com.krish.complaintportal.model.User;
import com.krish.complaintportal.model.Complaint;
import com.krish.complaintportal.repository.UserRepository;
import com.krish.complaintportal.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
import java.util.List;

@Controller
public class DashboardController {

    private final UserRepository userRepository;
    private final ComplaintService complaintService;

    @Autowired
    public DashboardController(UserRepository userRepository, ComplaintService complaintService) {
        this.userRepository = userRepository;
        this.complaintService = complaintService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByEmail(principal.getName()).orElse(null);
        model.addAttribute("user", user);

        // User's complaints
        List<Complaint> complaints = complaintService.getUserComplaints(user);
        model.addAttribute("complaints", complaints);

        // Stats
        int totalComplaints = complaints.size();
        int resolvedComplaints = (int) complaints.stream().filter(c -> "RESOLVED".equalsIgnoreCase(c.getStatus())).count();
        int pendingComplaints = totalComplaints - resolvedComplaints;
        model.addAttribute("totalComplaints", totalComplaints);
        model.addAttribute("resolvedComplaints", resolvedComplaints);
        model.addAttribute("pendingComplaints", pendingComplaints);

        return "dashboard";
    }
}
