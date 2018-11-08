package com.blog.springboot.dao;


import com.blog.springboot.bean.Article;
import com.blog.springboot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 詹奕凡
 * 对article表进行操纵的dao(data access object) 数据访问对象
 */
@Mapper
public interface ArticleDao {
    @Select("select * from article where userId=#{id}")
    @Results(
            @Result(property = "user",
                    column = "userId",
                    one = @One(select = "com.blog.springboot.dao.UserDao.getUserById")))
    /**
     * 根据用户查询文章
     * @param user 传入要查询文章的用户
     * @return List<Article> 查询出的所有文章，mybatis会根据字段自动封装成Article对象
     */
    List<Article> getArticleByUser(User user);

    @Select("select articleId,articleTime,articleTitle,articleContent,readCount,commentCount,url,articleAbstract " +
            "from article where url=#{arg0} and userid=#{arg1}")
    /**
     * 根据文章的uuid来查询文章
     * @param postid  文章的uuid
     * @param  userid 用户id
     * @return Article  查询出来的文章
     */
    Article getArticleByPostId(String postid,Integer userid);
    @Select("select articleId,articleTitle,url from article where articleId=#{xxx}")
    /**
     * 根据文章id来查询文章
     * @param id 文章id
     * @return 查询的文章对象
     */
    Article getArticleById(int id);

    @Update("update article set articleId=#{articleId},userId=#{user.id},articleTime=#{articleTime}," +
            "articleTitle=#{articleTitle},articleContent=#{articleContent},readCount=#{readCount},commentCount=#{commentCount},articleAbstract=#{articleAbstract}" +
            "where url=#{url}")
    /**
     * 根据传入的article对象进行文章的修改
     * @param article
     * @return void
     */
    void update(Article article);
    @Select("insert into article(articleId,userId,articleTime,articleTitle,articleContent,readCount,commentCount,url,articleAbstract) " +
            "values(#{articleId},#{user.id},#{articleTime},#{articleTitle},#{articleContent},#{readCount},#{commentCount},#{url},#{articleAbstract})")
    /**
     * 根据传入的article来添加文章
     * @param article
     * @return void
     */
    void insert(Article article);
    @Delete("delete from article where url=#{xxx}")
    /**
     * 根据文章的uuid 来删除文章
     * @param postid 文章的uuid
     * @return void
     */
    void delete(String postid);
}
