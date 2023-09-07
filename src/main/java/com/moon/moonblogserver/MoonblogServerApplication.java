package com.moon.moonblogserver;


import com.moon.moonblogserver.guestcomment.GuestCommentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableMongoRepositories(basePackageClasses = GuestCommentRepository.class)
@CrossOrigin(origins = "http://localhost:4321", allowCredentials = "true")
public class MoonblogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonblogServerApplication.class, args);
    }

}
