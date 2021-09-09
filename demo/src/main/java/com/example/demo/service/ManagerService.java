package com.example.demo.service;
import com.example.demo.Bean.ManagerBean;
import com.example.demo.result.CollectVO;
import com.example.demo.result.ManagerVO;
import com.example.demo.result.SumResultVO;
import com.example.demo.vo.Response;
import java.math.BigDecimal;
import java.util.List;
public interface ManagerService {


    /*
    *显示收入和支出的信息
    * @return
    * */
    public Response<List<ManagerVO>> showManager(int uid);

    /*
    * 显示当前的收入和支出的总和
    * @return
    * */
    public Response<List<CollectVO>> showByTname(int uid);

    /*
     * 显示当前的收入和支出的总和
     * @return
     * */
    public Response<List<CollectVO>> showBYTname(int uid,int month);
    /*
    * 最终财产金额
    * @return
    * */
    public Response<BigDecimal> showBySum(int uid);
    /*
     * 最终财产金额
     * @return
     * */
    public Response<SumResultVO> showBYSum(int uid);

    /**
     * 插入管理记录
     * @param ins
     * @return
     */
    public Response<ManagerBean> insert(ManagerBean ins);

}
