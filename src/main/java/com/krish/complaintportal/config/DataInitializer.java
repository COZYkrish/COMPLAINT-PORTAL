package com.krish.complaintportal.config;

import com.krish.complaintportal.model.User;
import com.krish.complaintportal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner createAdmin(UserRepository userRepository,
                                         BCryptPasswordEncoder passwordEncoder) {
        return args -> {

            String adminEmail = "admin@gmail.com";

            if (userRepository.findByEmail(adminEmail).isEmpty()) {

                User admin = new User();
                admin.setName("Administrator");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");  // ✅ IMPORTANT (NO ROLE_)

                userRepository.save(admin);

                System.out.println("✅ Admin user created successfully!");
            }
        };
    }
}
