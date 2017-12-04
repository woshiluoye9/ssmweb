package com.dustin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * <p> Description: </p>
 *
 * @author Wangsw
 * @date 2017/12/4下午 04:06
 * @Version 1.0.0
 */
@Controller
public class LoginController {

    // 用户登录验证控制
    @RequestMapping(value = "/login", method = {RequestMethod.POST , RequestMethod.GET})
    public String login(HttpSession session, String username, String password){

        // 校验用户登录名与密码

        // 将用户名密码放到session中
        session.setAttribute("username", username);

        // 返回到商品查询界面，重定向
        return "redirect:/queryItems";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){

        // 从session中消除用户
        session.invalidate();

        // 返回到商品查询界面，重定向
        return "redirect:/queryItems";

    }




}
