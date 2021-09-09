package com.example.demo.controller;

import com.example.demo.Bean.RegisterBean;
import com.example.demo.Bean.UserBean;
import com.example.demo.service.UserService;
import com.example.demo.util.ResponseUtil;
import com.example.demo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserCon {
    @Autowired
    UserService userService;
    @Autowired
    HttpSession httpSession;
    @PostMapping("/login")
    public Response<UserBean> login(HttpSession session, UserBean userBean){
        Response response= userService.login(userBean);
        if (response.getCode()==300){
            session.setAttribute("users",response.getData());
        }
        //return userService.login(userBean);
        return response;
    }

    @PostMapping("/register")
    public Response<RegisterBean> register(HttpSession session, RegisterBean registerBean){
        Response response1= userService.register(registerBean);
        if (response1.getCode()==300){
            session.setAttribute("register",response1.getData());
        }
        //return userService.login(userBean);
        return response1;
    }
    @GetMapping("/logout")
    public Response logout(HttpSession session) {
        session.setAttribute("users",null);//将用户值设为空

           return ResponseUtil.success(200,"退出成功",null);

    }
}
