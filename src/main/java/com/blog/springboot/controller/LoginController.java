package com.blog.springboot.controller;

import com.blog.springboot.bean.User;
import com.blog.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author 詹奕凡
 * 处理登陆请求
 */
@Controller
public class LoginController{
    @Autowired
    private UserService service;

    /**
     * 处理 用户登陆请求
     * @param username  用户输入的用户名
     * @param password  用户输入的密码
     * @param request
     * @return 视图名
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/user/signin",produces = "text/plain;charset=utf-8")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,
                        HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
//        String interceptorUrl = (String) request.getAttribute("interceptorUrl");
//        System.out.println(interceptorUrl);
        User user = new User(username, password);
        user=service.checkUser(user);
//        System.out.println(user);
        if(user!=null){
            session.setAttribute("loginUser",user);
            return "redirect:/blog/"+ URLEncoder.encode(username,"utf-8");
        }else{
            return "index";
        }
    }
}
