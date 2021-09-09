package com.example.demo.service.impl;

import com.example.demo.Bean.CollectBean;
import com.example.demo.Bean.ManagerBean;
import com.example.demo.Bean.UserBean;
import com.example.demo.Dao.ManagerDAO;
import com.example.demo.Dao.TypeDAO;
import com.example.demo.result.CollectVO;
import com.example.demo.result.ManagerVO;
import com.example.demo.result.SumResultVO;
import com.example.demo.service.ManagerService;
import com.example.demo.util.ResponseUtil;
import com.example.demo.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceimpl implements ManagerService {
    @Autowired
    TypeDAO typeDAO;

    @Autowired
    ManagerDAO managerDAO;



    @Override
    public Response<List<ManagerVO>> showManager(int uid) {
        List<ManagerVO> managerVOList=new ArrayList<>();//集合
        List<ManagerBean> managerBeans = managerDAO.selectByUid(uid);
        for(ManagerBean managerBean:managerBeans) {
            ManagerVO managerVO = new ManagerVO();
            managerVO.setId(managerBean.getId());
            managerVO.setUid(uid);
            managerVO.setPrice(managerBean.getPrice());
            managerVO.setMask(managerBean.getMask());
            managerVO.setMtime(managerBean.getMtime());
            managerVO.setTname(typeDAO.selectById(managerBean.getTid()).getTname());
            managerVOList.add(managerVO);
        }
        if(managerVOList.size()>0){
        return ResponseUtil.success(managerVOList);
        }
        return ResponseUtil.error(101,"没有错误");

    }

    @Override
    public Response<List<CollectVO>> showBYTname(int uid,int month) {
        List<CollectVO> collectVOList=new ArrayList<>();
        //ArrayList<>()类似与数组，利于查询；liunxList()利用插入和删除；如果从尾部插入都和数组插入形式差不多；
        //列表使用在接口（常量，抽象方法）抽象类（抽象方法），继承抽象类，实现方法，重写是用在子类中，重载是用在同一个函数中
        List<CollectBean> collectBeans= managerDAO.sum(uid,month);
        for(CollectBean collectBean:collectBeans){
            CollectVO collectVO=new CollectVO();
            collectVO.setTname(typeDAO.selectById(collectBean.getTid()).getTname());
            collectVO.setSum(collectBean.getSum());
            //1.将对应的变量类型都改为Bigdecimal 2.强制转换（new Bigecimal）or（Bigdecimal.valueOf()）
            collectVOList.add(collectVO);
        }
        if(collectVOList.size()>0){
            return ResponseUtil.success(collectVOList);
        }
        return ResponseUtil.error(102,"统计数据为空");
    }

   @Override
   public Response<List<CollectVO>> showByTname(int uid) {
       List<CollectVO> collectVOList=new ArrayList<>();//ManagedList<>()
       List<CollectBean> collectBeans= managerDAO.selectAll(uid);
       for(CollectBean collectBean:collectBeans){
           CollectVO collectVO=new CollectVO();
           collectVO.setTname(typeDAO.selectById(collectBean.getTid()).getTname());
           collectVO.setSum(collectBean.getSum());
           collectVOList.add(collectVO);
       }
       if(collectVOList.size()>0){
           return ResponseUtil.success(collectVOList);
       }
       return ResponseUtil.error(102,"统计数据为空");
   }
    @Override
    public Response<BigDecimal> showBySum(int uid) {
       Response<List<CollectVO>> response=showByTname(uid);
       List<CollectVO> collectVOS= response.getData();
       BigDecimal sum=new BigDecimal("0");//求和
       for(CollectVO c:collectVOS){
           if(c.getTname().equals("支出")){//减
               sum=sum.subtract(c.getSum());
           }
           if(c.getTname().equals("收入")){//加
               sum=sum.add(c.getSum());
           }
       }
    return ResponseUtil.success(sum);
    }
    @Override
    public Response<SumResultVO> showBYSum(int uid) {
        Response<List<CollectVO>> response=showByTname(uid);
        List<CollectVO> collectVOS= response.getData();
        BigDecimal sum=new BigDecimal("0");//求和
        System.out.println(collectVOS);
        for(CollectVO c:collectVOS){
            if(c.getTname().equals("支出")){//减
                sum=sum.subtract(c.getSum());
            }
            if(c.getTname().equals("收入")){//加
                sum=sum.add(c.getSum());
            }
        }
        SumResultVO sumResultVO=new SumResultVO();
        if(sum.compareTo(new BigDecimal("0"))>0){
            sumResultVO.setResult("剩余余额");
            sumResultVO.setSum(sum);
        }
        else{
            sumResultVO.setResult("负债");
            sumResultVO.setSum(sum.abs());

        }
        return ResponseUtil.success(sumResultVO);
    }

    @Override
    public Response<ManagerBean> insert(ManagerBean ins){
        if (ins == null) {
            return ResponseUtil.error(301, "都不能为空");
        }
        if (ins.getTid() == null) {
            return ResponseUtil.error(302, "类型id不能为空");
        }
        if (ins.getUid() == null) {
            return ResponseUtil.error(302, "用户id不能为空");
        }
        if (ins.getMtime() == null) {
            return ResponseUtil.error(303, "时间不能为空");
        }
        if (ins.getPrice() == null) {
            return ResponseUtil.error(303, "价钱不能为空");
        }
        managerDAO.insert(ins);
        return ResponseUtil.success(ins);
    }

}
