package com.example.demo.service.impl;

import com.example.demo.Bean.RegisterBean;
import com.example.demo.Bean.UserBean;
import com.example.demo.Dao.RegisterDAO;
import com.example.demo.Dao.UserDAO;
import com.example.demo.service.UserService;
import com.example.demo.util.ResponseUtil;
import com.example.demo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    RegisterDAO registerDAO;

    @Override
    public Response<UserBean> login(UserBean users){
        if(users==null){
            return ResponseUtil.error(201,"用户名和密码不能为空");
        }
        if(users.getUsername()==null)
        {
            return ResponseUtil.error(202,"用户名不能为空");
        }
        if(users.getUpassword()==null){
            return ResponseUtil.error(203,"密码不能为空");
        }
        UserBean ifname=userDAO.selectByUsername(users.getUsername());
        if(ifname==null){
            return ResponseUtil.error(204,"用户名有误，请重新输入");
        }
        UserBean ifupassword= userDAO.selectByUserAndPassword(users.getUsername(), users.getUpassword());
        if(ifupassword==null){
            return ResponseUtil.error(205,"密码有误，请重新输入");
        }
        ifupassword.setUpassword("");
        return ResponseUtil.success(ifupassword);
    }

    @Override
    public Response<RegisterBean> register(RegisterBean reg) {
        if (reg == null) {
            return ResponseUtil.error(201, "用户名，密码和邮箱不能为空");
        }
        if (reg.getUsername() == null) {
            return ResponseUtil.error(202, "用户名不能为空");
        }
        if (reg.getUpassword() == null) {
            return ResponseUtil.error(203, "密码不能为空");
        }
        if (reg.getEmail() == null) {
            return ResponseUtil.error(203, "邮箱不能为空");
        }
        registerDAO.insert(reg);
       return ResponseUtil.success(reg);
    }


}
