package com.moon.moonblogserver;


import com.moon.moonblogserver.guestcomment.GuestCommentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableMongoRepositories(basePackageClasses = GuestCommentRepository.class)

public class MoonblogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonblogServerApplication.class, args);
    }

}
