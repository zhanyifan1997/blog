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

@Controller
public class HomeContoller {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/blog/{username}")
    public String goHome(@PathVariable String username, HttpServletRequest request, Model model){
        User user=userService.getUserByName(username);
        request.setAttribute("loginUser",user);
        List<Article> articles = articleService.getArticleByUser(user);
        model.addAttribute("articles",articles);
        return "home";
    }
    @RequestMapping("/manage")
    public String goManage(HttpSession session,Model model){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser!=null){
            //查出当前用户的所有文章
            List<Article> articles = articleService.getArticleByUser(loginUser);
            model.addAttribute("articles",articles);
        }
        return "manage";
    }



}
