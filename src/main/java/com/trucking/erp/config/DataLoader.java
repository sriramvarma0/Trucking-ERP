package com.trucking.erp.config;

import com.trucking.erp.model.User;
import com.trucking.erp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // bcrypt
                admin.setRole("ADMIN");
                userRepository.save(admin);
                System.out.println("✅ Admin user created: admin/admin123");
            }
        };
    }
}
