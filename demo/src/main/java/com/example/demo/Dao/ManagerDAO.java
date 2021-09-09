package com.example.demo.Dao;
import com.example.demo.Bean.CollectBean;
import com.example.demo.Bean.ManagerBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

public interface ManagerDAO {

    /*
     *根据用户id进行查询
     * @Param uid
     * @return
     *  */
    @Select("select * from manager where uid=#{uid}")
    public List<ManagerBean> selectByUid(Integer uid);
    /*
     *根据用户id和类型id进行查询
     * @Param uid,tid
     * @return
     *  */
    @Select("select * from manager where uid=#{uid} and tid=#{tid}")
    public List<ManagerBean> selectByTidAndUid(Integer tid,Integer uid);
    /*
     *进行添加
     * @Param uid,tid,price,mtime,mask
     * @return
     *  */
    @Insert("insert into manager (uid,tid,price,mtime,mask) values(#{uid},#{tid},#{price},#{mtime},#{mask})")
    public int insert(ManagerBean managerBean);
    /*
     *修改数据
     * @Param id
     * @return
     *  */
    @Update("update manager set price=#{price} where id=#{id}")
    public int update(ManagerBean managerBean);
    /*
     *根据id进行删除
     * @Param id
     * @return
     *  */
    @Delete("delete from manager where id=#{id}")
    public int delete(Integer id);

    /*
     *根据月进行查询,年默认
     * @Param month
     * @return
     *  */
    @Select("select * from manager where Year(mtime)=Year(now()) and Month(mtime)=#{month} and uid=#{uid};")
    public List<ManagerBean> selectByDate(Integer uid,int month);

    @Select("select tid,sum(price) sum from manager\n" +
            "where Year(mtime)=Year(now()) and Month(mtime)=#{month} and uid=#{uid} group by tid" )
    public List<CollectBean> sum(Integer uid, int month);

    /*
     * 查询
     * @return
     * */
    @Select("select tid,sum(price) sum from manager where uid=#{uid} group by tid")
    public List<CollectBean> selectAll(Integer uid);

}
