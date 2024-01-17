package com.cms_springboot.cms_springboot.repository;

import com.cms_springboot.cms_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {
}
