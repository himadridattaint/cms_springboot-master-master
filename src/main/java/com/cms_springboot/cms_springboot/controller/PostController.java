package com.cms_springboot.cms_springboot.controller;

import com.cms_springboot.cms_springboot.entity.Post;
import com.cms_springboot.cms_springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/{pId}")
    public Post getPostById(@PathVariable Integer pId) {
        return postService.getPostById(pId);
    }
    @PostMapping
    public void savePost(@RequestBody Post post) {
        postService.savePost(post);
    }
    @DeleteMapping("/{pId}")
    public void deletePostById(@PathVariable Integer pId) {
        postService.deletePostById(pId);
    }
}
