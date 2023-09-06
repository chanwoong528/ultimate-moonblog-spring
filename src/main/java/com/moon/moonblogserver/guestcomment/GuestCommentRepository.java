package com.moon.moonblogserver.guestcomment;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestCommentRepository extends MongoRepository<GuestComment, ObjectId> {
}
