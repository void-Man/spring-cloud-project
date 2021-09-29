package com.cmj.example.utils;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/29
 */
public class RuntimeContextUtil {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setParam(String param){
        threadLocal.set(param);
    }

    public static String getParam(){
        return threadLocal.get();
    }

}
