package com.blog.springboot.controller;

import com.blog.springboot.bean.User;
import com.blog.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private LoginService service;
    @RequestMapping(value = "/user/signin",produces = "text/plain;charset=utf-8")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        String interceptorUrl = (String) request.getAttribute("interceptorUrl");
        System.out.println(interceptorUrl);
        User user = new User(username, password);
        user=service.checkUser(user);
        System.out.println(user);
        if(user!=null){
            session.setAttribute("loginUser",user);
            return "redirect:/blog/"+ URLEncoder.encode(username,"utf-8");
        }else{
            return "index";
        }
    }
}
