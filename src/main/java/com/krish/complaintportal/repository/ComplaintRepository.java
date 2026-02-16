package com.krish.complaintportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krish.complaintportal.model.Complaint;
import com.krish.complaintportal.model.User;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByUser(User user);
}
