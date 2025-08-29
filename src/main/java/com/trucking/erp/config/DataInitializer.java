package com.trucking.erp.config;

import com.trucking.erp.model.User;
import com.trucking.erp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User("admin", encoder.encode("admin123"), "ADMIN");
                userRepository.save(admin);
                System.out.println("✅ Default admin created: username=admin, password=admin123");
            }
        };
    }
}
