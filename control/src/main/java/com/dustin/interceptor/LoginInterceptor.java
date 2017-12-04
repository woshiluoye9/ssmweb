package com.dustin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p> Description: </p>
 *
 * @author Wangsw
 * @date 2017/12/4下午 04:20
 * @Version 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 进入handle之前执行
    // 主要用于身份认证，身份拦截

    /**
     * 用于登录之前的认证
     * 1. 如果请求的url是公开地址（无需登陆即可访问的url），让放行
     * 2.如果用户session 不存在跳转到登陆页面
     * 3.如果用户session存在放行，继续操作。
     */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取url
        String url = (String) request.getRequestURI();

        //1. 判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
        //这里公开地址是登陆提交的地址
        if(url.indexOf("login.action")>=0){
            //如果进行登陆提交，放行
            return true;
        }

        // 2. 用户session中是否存在
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if (!(username == null || username.equals(""))){
            return true;
        }

        // 3. 不存在，页面跳转到登录界面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

        return false;
    }
    // 进入handle之后，返回modelAndView之前执行
    // 增加一些页面公共的元素，比如说是页面的菜单栏
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    // handler 之后执行
    // 可以添加统一的异常处理机制 和日志 处理机制
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
