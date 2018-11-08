package com.blog.springboot.controller;


import com.blog.springboot.bean.Article;
import com.blog.springboot.bean.User;
import com.blog.springboot.service.ArticleService;
import com.blog.springboot.service.UserService;
import com.blog.springboot.util.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 詹奕凡
 */
@Controller
public class PageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    /**
     * 处理查看文章的请求
     * @param username 从路径变量中获取查看的用户
     * @param uuid 从路径变量中获取查看文章的uuid(唯一)
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/{username}/p/{uuid}")
    public String readArticle(@PathVariable String username,@PathVariable String uuid, HttpServletRequest request,Model model){
        User user=userService.getUserByName(username);
        request.setAttribute("loginUser",user);
        System.out.println(uuid);
        Article article = articleService.getArticleByPostId(uuid,user.getId());
        if(article!=null){

            Article lastArticle = articleService.getLastArticle(article);
            Article nextArticle = articleService.getNextArticle(article);

            article.setUser((User) request.getSession().getAttribute("loginUser"));
            model.addAttribute("article",article);
            return "article";
        }
        return "404";
    }

    /**
     * 处理跳转到添加随笔(更改随笔)的页面
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/EditPost")
    public String EditPost(HttpServletRequest request, Model model){
        String opt = request.getParameter("opt");
        User user = (User)request.getSession().getAttribute("loginUser");
        if(opt!=null){
            if("1".equals(opt)){
                //跳转新增随笔页面
                model.addAttribute("article",new Article());
                return "EditPost";
            }
        }else{
            //修改已存在的随笔
            //获取提交文章的id
            String postid=request.getParameter("postid");
            Article article = articleService.getArticleByPostId(postid,user.getId());
            article.setUser((User) request.getSession().getAttribute("loginUser"));
            model.addAttribute("article",article);
            return "EditPost";
        }
        return "";
    }

    /**
     * 接收新增随笔(修改随笔的请求)
     * @param map 接收前端用ajax发来的json串
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/EditPost")
    @ResponseBody
    public Map<String,String> EditPost(@RequestParam Map<String,String> map, HttpSession session,Model model){
        User user = (User)session.getAttribute("loginUser");
        String title = map.get("title");
        String articleAbstract = map.get("articleAbstract");
        String articleContent = map.get("articleContent");
        String postid = map.get("postid");
        if(postid==null||postid==""||postid.length()<7){
            postid= uuid.generateUUID();
            Article article=new Article((User)session.getAttribute(
                    "loginUser"),
                    new Date(),
                    title,
                    articleContent,
                    0,
                    0,
                    postid,
                    articleAbstract);
            articleService.addArticle(article);
        }else{
            Article article = articleService.getArticleByPostId(postid,user.getId());
            article.setUser((User) session.getAttribute("loginUser"));
            article.setArticleTitle(title);
            article.setArticleAbstract(articleAbstract);
            article.setArticleContent(articleContent);
            articleService.changeArticle(article);
        }
        Map json=new HashMap(0);
        json.put("href","success");
        json.put("postid",postid);
        return json;
    }

    /**
     * 处理删除随笔的请求
     * @param map 接收前端发送的ajax的json串
     * @return 返回一段消息，用于前端提醒
     */
    @DeleteMapping("/deleteArticle")
    @ResponseBody
    public String deleteArticle(@RequestParam Map<String,String> map){
        articleService.deleteArticle(map.get("postid"));
        return "删除成功";
    }
}
