package com.blog.springboot.bean;


public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer fans;
    private Integer order_;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getOrder_() {
        return order_;
    }

    public void setOrder_(Integer order_) {
        this.order_ = order_;
    }
    public User(String username, String password, Integer age, Integer fans, Integer order) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.fans = fans;
        this.order_ = order;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", fans=" + fans +
                ", order=" + order_ +
                '}';
    }
}
