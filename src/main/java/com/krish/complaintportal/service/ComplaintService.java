package com.krish.complaintportal.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.krish.complaintportal.model.Complaint;
import com.krish.complaintportal.model.User;
import com.krish.complaintportal.repository.ComplaintRepository;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    // public Complaint saveComplaint(Complaint complaint) {
    //     return complaintRepository.save(complaint);
    // }

    public List<Complaint> getUserComplaints(User user) {
        return complaintRepository.findByUser(user);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public void updateStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id).orElseThrow();
        complaint.setStatus(status);
        complaintRepository.save(complaint);
    }
    public void resolveComplaint(Long id) {
    Complaint complaint = complaintRepository.findById(id).orElseThrow();
    complaint.setStatus("RESOLVED");
    complaintRepository.save(complaint);
}

}
