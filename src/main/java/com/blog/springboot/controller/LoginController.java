package com.blog.springboot.controller;

import com.blog.springboot.bean.User;
import com.blog.springboot.service.UserService;
import com.blog.springboot.util.MD5_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 詹奕凡
 * 处理登陆请求,注册请求
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
        User user = new User(username, MD5_util.MD5(password));
        user=service.checkUser(user);
//        System.out.println(user);
        if(user!=null){
            session.setAttribute("loginUser",user);
            return "redirect:/blog/"+ URLEncoder.encode(username,"utf-8");
        }else{
            return "index";
        }
    }

    /**
     * 处理用户注册请求
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/user/register")
    @ResponseBody
    public String register(String username, String password, Model model){
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5_util.MD5(password));
        service.registerUser(user);
        model.addAttribute("url","index.html");
        return "<h1>注册成功！</h1><br><a href='http://localhost:8080/index.html'>返回登陆</a>";
    }
}
