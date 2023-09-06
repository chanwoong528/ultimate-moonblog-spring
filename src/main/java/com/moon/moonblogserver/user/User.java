package com.moon.moonblogserver.user;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "blogUser", uniqueConstraints = @UniqueConstraint(columnNames = {"loginType", "email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "loginType")
    private String loginType;
    @Column(name = "email")
    private String email;
    private String name;
    private String pw;

    @Column(name = "createdDate", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;
    @Column(name = "updatedDate", nullable = true, updatable = true)
    private Date updatedDate;

    @Column(name = "verified")
    private char verified = 'N';

    public User() {
    }

    public User(String loginType, String email, String name, String pw) {
        this.loginType = loginType;
        this.email = email;
        this.name = name;
        this.pw = pw;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public UUID getId() {
        return id;
    }


    public String getLoginType() {
        return loginType;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public char getVerified() {
        return verified;
    }


}
