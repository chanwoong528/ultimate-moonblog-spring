package com.example.moonblogserver.user;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String loginType;
    private String email;
    private String name;
    private String pw;

    @Column(name = "ddate", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;
    private Date updatedDate;

    @ColumnDefault("N")
    private char verified;

    public User() {
    }
    public User(String loginType, String email, String name, String pw) {
        this.loginType = loginType;
        this.email = email;
        this.name = name;
        this.pw = pw;
    }


}
