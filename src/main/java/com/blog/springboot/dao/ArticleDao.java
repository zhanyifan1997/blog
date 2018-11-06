package com.blog.springboot.dao;


import com.blog.springboot.bean.Article;
import com.blog.springboot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao {
    @Select("select * from article where userId=#{id}")
    @Results(
            @Result(property = "user",
                    column = "userId",
                    one = @One(select = "com.blog.springboot.dao.UserDao.getUserById")))
    List<Article> getArticleByUser(User user);
    @Select("select articleId,articleTime,articleTitle,articleContent,readCount,commentCount,url,articleAbstract from article where url=#{arg0} and userid=#{arg1}")
    Article getArticleByPostId(String postid,Integer userid);
    @Select("select articleId,articleTitle,url from article where articleId=#{xxx}")
    Article getArticleById(int id);
    @Update("update article set articleId=#{articleId},userId=#{user.id},articleTime=#{articleTime}," +
            "articleTitle=#{articleTitle},articleContent=#{articleContent},readCount=#{readCount},commentCount=#{commentCount},articleAbstract=#{articleAbstract}" +
            "where url=#{url}")
    void update(Article article);
    @Select("insert into article(articleId,userId,articleTime,articleTitle,articleContent,readCount,commentCount,url,articleAbstract) " +
            "values(#{articleId},#{user.id},#{articleTime},#{articleTitle},#{articleContent},#{readCount},#{commentCount},#{url},#{articleAbstract})")
    void insert(Article article);
    @Delete("delete from article where url=#{xxx}")
    void delete(String postid);
}
