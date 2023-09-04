package com.example.moonblogserver.post;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//MONGO

@Document(collection = "posts")
public class Post {

    @Id
    private ObjectId id;

    private String title;
    private String content;
    private String postedDate;
    private String editedDate;
    private String categoryId;


}
