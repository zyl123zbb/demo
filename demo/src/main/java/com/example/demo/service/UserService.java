package com.example.demo.service;

import com.example.demo.Bean.RegisterBean;
import com.example.demo.Bean.UserBean;
import com.example.demo.vo.Response;
import sun.security.jgss.HttpCaller;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 登录的实现
     * @param users
     * @return
     */
    public Response<UserBean> login(UserBean users);

    /**
     * 注册的实现
     * @param reg
     * @return
     */
    public Response<RegisterBean> register(RegisterBean reg);


}
