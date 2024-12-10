package com.theXunnY.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.theXunnY.entity.User;
import com.theXunnY.repository.UserRepository;

@Component
public class DataInitializer {

	@Autowired
    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            // Log to verify if the count check is working
            long count = userRepository.count();
            System.out.println("Number of users in the database: " + count);

            if (count == 0) {
                User user1 = new User(
                        0, "rajesh", "nobi", "rajesh@example.com", 1234567890,
                        passwordEncoder.encode("password123"), "USER"
                );
                User user2 = new User(
                        10, "ramesh", "nohara", "rameshh@example.com", 987651210,
                        passwordEncoder.encode("password456"), "ADMIN"
                );
                User user3 = new User(
                        40, "suresh", "gonda", "suresh@example.com", 1122334455,
                        passwordEncoder.encode("password789"), "USER"
                );
                User user4 = new User(
                        70, "jayesh", "uchiha", "jayesh@example.com", 66779900,
                        passwordEncoder.encode("password101"), "ADMIN"
                );

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);

                System.out.println("Users saved successfully!");
            } else {
                System.out.println("Users already exist, skipping insertion.");
            }
        };
    }

    
}
