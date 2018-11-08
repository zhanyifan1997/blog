package com.blog.springboot.component;

import com.blog.springboot.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 詹奕凡
 * register a login interceptor to intercep the login request
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //get loginUser from session
        User user = (User)httpServletRequest.getSession().getAttribute("loginUser");
        //if null that mean the session hasn't the user， that should login if want to change the blog
        if(user==null || user.getPassword() ==null){
            httpServletRequest.setAttribute("msg","没有权限请先登陆");
            //requests Forward to the index page
            httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest,httpServletResponse);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
