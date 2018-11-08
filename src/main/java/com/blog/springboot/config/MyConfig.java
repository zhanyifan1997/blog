package com.blog.springboot.config;

import com.blog.springboot.component.LoginHandlerInterceptor;
import com.blog.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @author 詹奕凡
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
    //实际开发中会涉及到大量的页面跳转。我们可以重写addViewControllers来简化页面的跳转。

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加了一些映射规则，访问对应的视图名称时，会跳转到对应的html页面
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/home.html").setViewName("home");
        registry.addViewController("/EditPost.html").setViewName("EditPost");
        registry.addViewController("/simple.html").setViewName("simple");
        registry.addViewController("/show.html").setViewName("show");
        registry.addViewController("/success.html").setViewName("success");
    }
    /**
     * 注册国际化组件
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求，除了excludePatterns中的那些url
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index.html","/","/user/signin","/blog/*","/*/p/*");
    }

}
