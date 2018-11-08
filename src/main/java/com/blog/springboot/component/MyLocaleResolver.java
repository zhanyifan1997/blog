package com.blog.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 詹奕凡
 * this class implement international
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取默认的本地语言
        Locale locale=Locale.getDefault();
        //获取请求参数中的l，用来标识语言
        String l=httpServletRequest.getParameter("l");
        if(!StringUtils.isEmpty(l)){
            //l参数的形式为 zh_CN,en_us
            //根据_分割，创建出用户希望的语言
            String []strs=l.split("_");
            locale=new Locale(strs[0],strs[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }
}
