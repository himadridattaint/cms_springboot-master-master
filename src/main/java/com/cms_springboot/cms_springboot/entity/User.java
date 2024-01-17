package com.cms_springboot.cms_springboot.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    private Integer userId;
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Post> posts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="p_id")
    private Post post;

//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }

    public User()
    {

    }

    public User(Integer userId, String name, String userName, String email, String phoneNumber, Post post) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.post = post;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



}
