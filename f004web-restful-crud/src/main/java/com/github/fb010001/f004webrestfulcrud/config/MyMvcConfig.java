package com.github.fb010001.f004webrestfulcrud.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 *@Title 使用WebMvcConfigurerAdapter　来扩展SpringMvc的功能
 *＠author    fangbin
 *@Date 19-12-25 下午3:53
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        // 浏览器发送　ｆｂ转发到ｓｕｃｃｅｓｓ页面
        registry.addViewController("/fb").setViewName("success");
    }

    //所有的ＷｅｂＭｖｃＣｏｎｆｉｇｕｒａｔｉｏｎ组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            //视图映射器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
            }
        };
        return webMvcConfigurerAdapter;
    }
}
