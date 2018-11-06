package com.blog.springboot.service;

import com.blog.springboot.bean.User;
import com.blog.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {
    @Autowired
    private UserDao dao;
    public User checkUser(User user){
        user=dao.checkUser(user);
        return user;
    }
}