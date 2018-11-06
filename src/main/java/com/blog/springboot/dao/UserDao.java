package com.blog.springboot.dao;

import com.blog.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select id,username,password,age,fans,order_ from user_ where username=#{username} and password=#{password}")
    User checkUser(User user);
    @Select("select id,username,age,fans,order_ from user_ where username=#{xxx}")
    User getUserByName(String username);
    @Select("select id,username,age,fans,order_ from user_ where id=#{xxx}")
    User getUserById(String id);
}
