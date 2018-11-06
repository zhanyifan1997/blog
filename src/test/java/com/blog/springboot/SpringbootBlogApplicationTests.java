package com.blog.springboot;

import com.blog.springboot.bean.Article;
import com.blog.springboot.bean.User;
import com.blog.springboot.dao.ArticleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBlogApplicationTests {
    @Autowired
    ArticleDao dao;
    @Test
    public void contextLoads() {
        User user=new User();
        user.setId(1);
//        Article article = dao.getArticleByPostId("c8f5329");
//        System.out.println(article);
        List<Article> articleByUser = dao.getArticleByUser(user);
        System.out.println("size="+articleByUser.size());
        for (Article article:articleByUser) {
            System.out.println(article);
        }
    }
//    public void test(){
//        for(int i=0;i<10;i++){
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            System.out.println(uuid);
//        }
//    }

}
