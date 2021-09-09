package com.example.demo.vo;
import lombok.Data;
@Data
public class Response <T>{
    private Integer code;
  /*存放状态码，比如100-199用户信息的状态码，
   *其中100，用户登录成功，101用户密码错误，等；
   *300-399：财务管理的
   */
    private String massage;//300，添加类型成功
    private T data;//存放数据
}
