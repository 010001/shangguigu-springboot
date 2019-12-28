package com.github.fb010001.f004webrestfulcrud.component;

import com.github.fb010001.f004webrestfulcrud.utils.MyStringUtils;
import com.sun.corba.se.spi.orbutil.closure.Closure;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.apache.tomcat.jni.Local;
import org.omg.CORBA.Object;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/***
 *@Title 可以在链接上携带区域信息
 * 区域信息解析器
 *＠author    fangbin
 *@Date 19-12-27 下午2:42
 */
public class MyLocalRsolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] strings = l.split("_");
            locale = new Locale(strings[0],strings[1]);
        } else {
            List<String> zhLocaleStr = new ArrayList<String>();
            zhLocaleStr.add("zh");
            zhLocaleStr.add("zh-CN");
            String contentLanguage = request.getHeader("Accept-Language");
            if(MyStringUtils.isNotEmpty(contentLanguage)){
                String[] languages = contentLanguage.split(",");
                if(languages.length > 0){
                    for (String language: languages
                         ) {
                        if(zhLocaleStr.contains(language)){
                            locale = new Locale("zh","CN");
                            break;
                        } else {
                            locale = new Locale("en","US");
                            break;
                        }
                    }
                }
            }
            /*if(MyStringUtils.isNotEmpty(contentLanguage)){
                String[] split = contentLanguage.split("-");
                locale = new Locale(split[0],split[1]);
            }*/
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

}
