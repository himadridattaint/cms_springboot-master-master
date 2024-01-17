package com.cms_springboot.cms_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Post {
    @Id
    private Integer postId;
    private String title;
    private String content;
    private String date;
public Post()
{

}
    public Post(Integer postId, String title, String content, String date) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
