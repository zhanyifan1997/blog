package com.blog.springboot.service;

import com.blog.springboot.bean.User;
import com.blog.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 詹奕凡
 */
@Service
public class UserService {
    @Autowired
    private UserDao dao;
    public User getUserByName(String username){
        return dao.getUserByName(username);
    }
    public User checkUser(User user){
        user=dao.checkUser(user);
        return user;
    }
}
