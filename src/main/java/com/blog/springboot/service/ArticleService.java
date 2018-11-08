package com.blog.springboot.service;

import com.blog.springboot.bean.Article;
import com.blog.springboot.bean.User;
import com.blog.springboot.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 詹奕凡
 * 对article进行操作的service类
 */
@Service
public class ArticleService {
    /**
     * 自动注入dao对象
     */
    @Autowired
    ArticleDao articleDao;
    public List<Article> getArticleByUser(User user){
        return articleDao.getArticleByUser(user);
    }
    public Article getArticleByPostId(String postid,Integer userId){
        return articleDao.getArticleByPostId(postid,userId);
    }
    public void changeArticle(Article article){
        articleDao.update(article);
    }
    public void addArticle(Article article){
        articleDao.insert(article);
    }
    public void deleteArticle(String postid){
        articleDao.delete(postid);
    }
    public Article getLastArticle(Article article){
        return null;
    }
    public Article getNextArticle(Article article){
        return null;
    }

}
