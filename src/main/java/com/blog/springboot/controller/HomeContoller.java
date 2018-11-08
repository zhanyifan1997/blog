package com.blog.springboot.controller;

import com.blog.springboot.bean.Article;
import com.blog.springboot.bean.User;
import com.blog.springboot.dao.ArticleDao;
import com.blog.springboot.service.ArticleService;
import com.blog.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 詹奕凡
 * 处理home页面的请求
 */
@Controller
public class HomeContoller {
    /**
     *
     * Autowired 自动注入userService和articleService，由spring自动创建
     */
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    /**
     * 拦截/blog下的所有请求，/blog下的一级url被当作用户名来处理
     * 通过userService的方法，来查询出这个用户
     * 把这个查询出来的用户放入request，查询出这个用户的所有文章
     * @param username 从路径变量{username}中获取
     * @param request
     * @param model 用于向跳转页面发送一些数据
     * @return 跳转到home页面
     */
    @RequestMapping("/blog/{username}")
    public String goHome(@PathVariable String username, HttpServletRequest request, Model model){
        User user=userService.getUserByName(username);
        request.setAttribute("loginUser",user);
        List<Article> articles = articleService.getArticleByUser(user);
        model.addAttribute("articles",articles);
        return "home";
    }

    /**
     * 跳转到后台管理页面
     * 查询出用户的所有文章，用于显示
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/manage")
    public String goManage(HttpSession session,Model model){
        //因为这个请求会被拦截器拦截，迫使用户进行登陆，所有session中会有登陆用户
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser!=null){
            //查出当前用户的所有文章
            List<Article> articles = articleService.getArticleByUser(loginUser);
            model.addAttribute("articles",articles);
        }
        return "manage";
    }



}
