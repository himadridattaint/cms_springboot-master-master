package com.cms_springboot.cms_springboot.service;

import com.cms_springboot.cms_springboot.entity.Post;
import com.cms_springboot.cms_springboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post getPostById(Integer pId) {
        return postRepository.findById(pId).orElse(null);
    }
    public void savePost(Post post) {
        postRepository.save(post);
    }
    public void deletePostById(Integer pId) {
        postRepository.deleteById(pId);
    }

}
