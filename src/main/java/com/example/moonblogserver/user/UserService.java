package com.example.moonblogserver.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createdOneUser(String loginType, String email, String name, String pw) {
        User newUser = new User(loginType, email, name, pw);
        return userRepository.save(newUser);
    }

}
