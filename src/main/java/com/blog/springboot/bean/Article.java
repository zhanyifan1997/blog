package com.blog.springboot.bean;

import java.util.Date;

/**
 * create a  Article javabean to mapping the db table
 */
public class Article {
    private Integer articleId;
    private User user;
    private Date articleTime;
    private String articleTitle;
    private String articleContent;
    private Integer readCount;
    private Integer commentCount;
    private String url;
    private String articleAbstract;


    public Article() {
    }

    public Article(User user, Date articleTime, String articleTitle, String articleContent, Integer readCount, Integer commentCount, String url,String articleAbstract) {
        this.user = user;
        this.articleTime = articleTime;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.readCount = readCount;
        this.commentCount = commentCount;
        this.url = url;
        this.articleAbstract=articleAbstract;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", user=" + user +
                ", articleTime=" + articleTime +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", readCount=" + readCount +
                ", commentCount=" + commentCount +
                ", url='" + url + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                '}';
    }
}
