package com.github.fb010001.f004webrestfulcrud.controller;

import com.github.fb010001.f004webrestfulcrud.utils.MyStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-27 下午4:05
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Map<String,Object> map,
            HttpSession session){
        if(MyStringUtils.isNotEmpty(username) && "111".equalsIgnoreCase(password)){
            //登录成功
            session.setAttribute("loginUser",username);
            // 为防止表单重复提交，登录成功后可以重定向到主页
            return "redirect:/main.html";
        } else {
            map.put("msg","帐号密码错误");
            return "login";
        }
    }
    @PostMapping("/user/logout")
    public String logout(HttpSession session){
        session.setAttribute("loginUser","");
        return "redirect:/";
    }
}
