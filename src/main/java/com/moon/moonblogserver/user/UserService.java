package com.moon.moonblogserver.user;

import com.moon.moonblogserver.category.Category;
import com.moon.moonblogserver.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createdOneUser(User userInfo) {
    User existUser = userRepository.findByEmailAndLoginType(userInfo.getEmail(), userInfo.getLoginType()).orElse(null);
    if (existUser == null) {

      if (userInfo.getPw() == null || userInfo.getPw().equals("")) {
        userInfo.setPw("snsloginpw");
      } else {
        String hashedPassword = new BCryptPasswordEncoder(10).encode(userInfo.getPw());
        userInfo.setPw(hashedPassword);
      }
      return userRepository.save(userInfo);
    }
    return existUser;
  }

  public User patchOneUser(User patchUserInfo) {
    User existUser = userRepository.findByEmailAndLoginType(patchUserInfo.getEmail(), patchUserInfo.getLoginType()).orElseThrow(() -> new ResourceNotFoundException("patchUserInfo not exist with id :" + patchUserInfo.getEmail() + patchUserInfo.getLoginType()));

    existUser.setMarketingConsent(patchUserInfo.getMarketingConsent());
    existUser.setPrivacyConsent(patchUserInfo.getPrivacyConsent());
    existUser.setVerified('Y');

    return userRepository.save(existUser);
  }

  public Optional<User> findOneUser(String email, String loginType) {

    return userRepository.findByEmailAndLoginType(email, loginType);
  }

}
