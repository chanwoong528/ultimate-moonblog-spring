package com.example.moonblogserver.post;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

//MONGO
@Document(collection = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID categoryId;

    private String titleKor;
    private String titleEng;
    private String contentKor;
    private String contentEng;
    private String postedDate;
    private String editedDate;

    @ColumnDefault("0")
    private int views;
    @ColumnDefault("0")
    private int shareCount;
    @ColumnDefault("0")
    private int likeCount;
    @ColumnDefault("0")
    private int dislikeCount;

    public Post(UUID categoryId, String titleKor, String titleEng, String contentKor, String contentEng, String postedDate) {
        this.categoryId = categoryId;
        this.titleKor = titleKor;
        this.titleEng = titleEng;
        this.contentKor = contentKor;
        this.contentEng = contentEng;
        this.postedDate = postedDate;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getTitleKor() {
        return titleKor;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public String getContentKor() {
        return contentKor;
    }

    public String getContentEng() {
        return contentEng;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public String getEditedDate() {
        return editedDate;
    }

    public int getViews() {
        return views;
    }

    public int getShareCount() {
        return shareCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }
}
