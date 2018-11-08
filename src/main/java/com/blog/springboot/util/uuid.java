package com.blog.springboot.util;

import java.util.UUID;

/**
 * 生成uudi的类
 * @author 詹奕凡
 */
public class uuid {
    public static String generateUUID(){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        return uuid.substring(0,7);
    }
}
