package com.blog.springboot.dao;

import com.blog.springboot.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author  詹奕凡
 * 对 user(data access object) 数据访问对象
 */
@Mapper
public interface UserDao {
    @Select("select id,username,password,age,fans,order_ from user_ where username=#{username} and password=#{password}")
    /**
     * 根据传入的用户，验证用户是否存在，如果存在，返回查询出来的所有信息，如果不存在，返回null
     * @param user
     */
    User checkUser(User user);

    @Select("select id,username,age,fans,order_ from user_ where username=#{xxx}")
    /**
     * 根据传入的用户名，查询用户，如果存在，返回查询的信息(除了password)，否则返回null
     * @param username
     * @return user
     */
    User getUserByName(String username);
    @Select("select id,username,age,fans,order_ from user_ where id=#{xxx}")
    /**
     * 根据id查询 user
     * @param id
     */
    User getUserById(String id);

    /**
     * insert a user into db
     * @param user
     */
    @Insert("insert into user_(username,password) values(#{username},#{password})")
    void registerUser(User user);

}
