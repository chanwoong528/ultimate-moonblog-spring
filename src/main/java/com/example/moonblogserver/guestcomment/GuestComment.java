package com.example.moonblogserver.guestcomment;


import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Document(collection = "post")
public class GuestComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;

    private String content;
    private Date createdDate;
    private Date updatedDate;
    @ColumnDefault("0")
    private int likes;
    @ColumnDefault("0")
    private int dislikes;

    public GuestComment() {
    }

    public GuestComment(UUID userId, String content, Date createdDate) {
        super();
        this.userId = userId;
        this.content = content;
        this.createdDate = createdDate;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public int getLikes() {
        return likes;
    }
    public int getDislikes() {
        return dislikes;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }


}
