package com.krish.complaintportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.krish.complaintportal.service.ComplaintService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ComplaintService complaintService;

    public AdminController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("complaints", complaintService.getAllComplaints());
        return "admin-dashboard";
    }

    @PostMapping("/resolve/{id}")
    public String resolveComplaint(@PathVariable Long id) {
        complaintService.updateStatus(id, "RESOLVED");
        return "redirect:/admin/dashboard";
    }
}
