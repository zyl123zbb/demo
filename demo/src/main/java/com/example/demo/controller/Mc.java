package com.example.demo.controller;

import com.example.demo.Bean.ManagerBean;
import com.example.demo.Bean.TypeBean;
import com.example.demo.Bean.UserBean;
import com.example.demo.result.CollectVO;
import com.example.demo.result.ManagerVO;
import com.example.demo.result.SumResultVO;
import com.example.demo.service.ManagerService;
import com.example.demo.util.ResponseUtil;
import com.example.demo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class Mc {
   @GetMapping("/index")
    public String index()
   {
       return "hello student";
   }
   @GetMapping("/put")
   public String put(String typename)
   {
       return typename;
   }
    @GetMapping("/put/{typename}")
   public String put2(@PathVariable String typename){
       return typename;
   }
   @GetMapping("/put3")
   public String put3(@RequestParam(defaultValue = "支出",required = false)String typename){
       return typename;
   }

    /*@PostMapping("/put")
    public TypeBean postinsert(TypeBean type){
       System.out.println(type);
       return type;
   }*/
   @PostMapping("/put")
   public Response<TypeBean> postinsert(TypeBean type){
       System.out.println(type);
       return ResponseUtil.success(300,"添加成功",type);
   }

   @Autowired
   ManagerService managerService;

   @GetMapping("show/all")
   public Response<List<ManagerVO>> show(HttpSession session){
       UserBean usersBean=(UserBean) session.getAttribute("users");
       if(usersBean==null){
           return ResponseUtil.error(206,"用户没有登录，不能进行");
       }
       //System.out.println(session.getAttribute("users"));
       return managerService.showManager(usersBean.getId());

   }
    @GetMapping("show/allr")
    public Response<List<ManagerVO>> showr(HttpSession session){
        UserBean registerBean=(UserBean) session.getAttribute("register");
        if(registerBean==null){
            return ResponseUtil.error(209,"用户没有注册，不能进行");
        }
        //System.out.println(session.getAttribute("users"));
        return managerService.showManager(registerBean.getId());

    }
   @GetMapping("show/collect")
   public Response<List<CollectVO>> showCollect(HttpSession session)
   {
       UserBean usersBean=(UserBean) session.getAttribute("users");
       if(usersBean==null){
           return ResponseUtil.error(206,"用户没有登录，不能进行");
       }
       //return managerService.showByTname(1);
       return managerService.showByTname(usersBean.getId());



}
    @GetMapping("show/collectr")
    public Response<List<CollectVO>> showCollectr(HttpSession session)
    {
        UserBean registerBean=(UserBean) session.getAttribute("register");
        if(registerBean==null){
            return ResponseUtil.error(209,"用户没有注册，不能进行");
        }
        //return managerService.showByTname(1);
        return managerService.showByTname(registerBean.getId());


    }
   @GetMapping("show/sumall")
   public Response<SumResultVO> showSum(HttpSession session)
   {
       UserBean usersBean=(UserBean) session.getAttribute("user");
       if(usersBean==null){
           return ResponseUtil.error(206,"用户没有登录，不能进行");
       }
       //return managerService.showBYSum(1);
       return managerService.showBYSum(usersBean.getId());
   }
    @GetMapping("show/sumallr")
    public Response<SumResultVO> showSumr(HttpSession session)
    {
        UserBean registerBean=(UserBean) session.getAttribute("register");
        if(registerBean==null){
            return ResponseUtil.error(209,"用户没有注册，不能进行");
        }
        //return managerService.showBYSum(1);
        return managerService.showBYSum(registerBean.getId());
    }
    @PostMapping("/manager/insert")
    public Response insert(HttpSession session, ManagerBean managerBean){
        UserBean users=(UserBean) session.getAttribute("users");
        if(users==null){
            return ResponseUtil.error(309,"用户没有登录，不能进行");
        }
        ManagerBean manager=new ManagerBean();
        manager.setId(4);
        manager.setTid(2);
        manager.setPrice(new BigDecimal("12"));
        manager.setUid(2);
        manager.setMask("奶茶");
        manager.setMtime(new Timestamp(System.currentTimeMillis()));//System.currentTimeMills()函数用于获取当前时间
        return managerService.insert(managerBean);

    }


   /* @PostMapping("/data")
    public Response dateshow(String dateString){
        Timestamp data=DateStringTimestamp.getTimestamp(dateString);
        return ResponseUtil.success(data);
    }*/
}
