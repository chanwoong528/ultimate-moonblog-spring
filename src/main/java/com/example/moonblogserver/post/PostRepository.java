package com.example.moonblogserver.post;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PostRepository extends MongoRepository<Post, ObjectId> {


}

