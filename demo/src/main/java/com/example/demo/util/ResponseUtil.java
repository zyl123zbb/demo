package com.example.demo.util;

import com.example.demo.Bean.TypeBean;
import com.example.demo.vo.Response;

public class ResponseUtil {
    public static <T> Response<T> success(Integer code,String message,T data){
        Response<T> response=new Response<>();
        response.setCode(code);
        response.setMassage(message);
        response.setData(data);
        return response;
    }
    public static <T>Response<T> success(T data) //重载
    {
        Response<T> response=new Response<>();
        response.setCode(300);
        response.setMassage("财务管理成功");
        response.setData(data);
        return response;
    }

    public static<T> Response error(Integer code,String message) //重载
    {
        Response<T> response=new Response<>();
        response.setCode(code);
        response.setMassage(message);
        response.setData(null);
        return response;
    }
}
