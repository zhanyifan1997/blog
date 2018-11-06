package com.blog.springboot.service;

import com.blog.springboot.bean.User;
import com.blog.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;
    public User getUserByName(String username){
        return dao.getUserByName(username);
    }
}
