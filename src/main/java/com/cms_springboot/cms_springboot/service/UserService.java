package com.cms_springboot.cms_springboot.service;

import com.cms_springboot.cms_springboot.entity.User;
import com.cms_springboot.cms_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer uId) {
        return userRepository.findById(uId).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Integer uId) {
        userRepository.deleteById(uId);
    }
}
