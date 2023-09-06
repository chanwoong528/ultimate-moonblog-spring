package com.moon.moonblogserver.user;

import com.moon.moonblogserver.common.JwtManager;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private JwtManager jwtManager;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> postOneUser(@RequestBody User userInfo) {
        jwtManager = new JwtManager();
        User createdUser = userService.createdOneUser(userInfo);
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(createdUser.getEmail());
        userResponse.setLoginType(createdUser.getLoginType());
        userResponse.setName(createdUser.getName());
        userResponse.setId(createdUser.getId());

        String accessToken = jwtManager.generateJwtAccessToken(createdUser);
        String refreshToken = jwtManager.generateJwtRefreshToken(createdUser);
        userResponse.setAccessToken(accessToken);
        userResponse.setRefreshtoken(refreshToken);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<String> postAccessToken(@RequestParam("accessToken") String accessToken) {
        jwtManager = new JwtManager();
        try {
            String emailFromToken = jwtManager.getEmailFromToken(accessToken);
            return new ResponseEntity<String>(emailFromToken, HttpStatus.OK);
        } catch (ExpiredJwtException e1) {

            return new ResponseEntity<String>("emailFromToken", HttpStatus.NOT_ACCEPTABLE);
        }


    }
}
