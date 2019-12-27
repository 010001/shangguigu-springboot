package com.github.fb010001.f004webrestfulcrud.utils;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-27 下午2:57
 */
public class MyStringUtils {

    public static boolean isEmpty(String str){
        if(null == str){
            return true;
        }
        return "".equalsIgnoreCase(str.trim());
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
