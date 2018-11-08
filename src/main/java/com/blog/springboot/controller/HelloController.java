package com.blog.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 詹奕凡
 * 测试springmvc是否正常运行
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello,world";
    }
}
