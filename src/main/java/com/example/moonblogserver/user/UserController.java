package com.example.moonblogserver.user;

import com.example.moonblogserver.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> postOneUser(@RequestBody User userInfo) {
//        String hashedPw = userInfo.pw;
        User newUser = new User();
//        User newUser = userService.createdOneUser(userInfo.loginType, userInfo.email, userInfo.name, );
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
