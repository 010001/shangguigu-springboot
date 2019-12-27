package com.github.fb010001.f004webrestfulcrud.controller;

import com.github.fb010001.f004webrestfulcrud.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-17 下午5:14
 */
@Controller
public class WebController {

    /*@RequestMapping({"/","index.html"})
    public String index(){
        return "index";
    }*/

    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!!!";
    }

    /**
     * 查出一些数据，在页面展示
     * @return
     */
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
