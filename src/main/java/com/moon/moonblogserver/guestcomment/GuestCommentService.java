package com.moon.moonblogserver.guestcomment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestCommentService {
    @Autowired
    private GuestCommentRepository guestCommentRepository;

    public List<GuestComment> allGuestComments() {
        return guestCommentRepository.findAll();
    }

//    public GuestComment oneGuestComment(UUID id) {
//        return guestCommentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//    }

}
