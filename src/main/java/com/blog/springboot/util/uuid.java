package com.blog.springboot.util;

import java.util.UUID;

public class uuid {
    public static String generateUUID(){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        return uuid.substring(0,7);
    }
}
