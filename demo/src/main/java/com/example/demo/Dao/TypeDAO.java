package com.example.demo.Dao;

import com.example.demo.Bean.TypeBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//自动生成测试文件：shift+ctrl+T
public interface TypeDAO {
    /*
     * 查询所有的数据
     * 使用注解的形式实现sql语句
     * @return
     */
    @Select("select tid,tname from type")
    public List<TypeBean> selectAll();
    //查询
    @Select("select tid,tname from type where tid=#{tid}")
    public TypeBean selectById(Integer tid);
    //改
    @Update("update type set tname=#{tname} where tid=#{tid}")
    public int update(TypeBean type);
    //删
    @Delete("delete from type where tid=#{tid}")
    public int delete(Integer tid);
    //增
    @Insert("insert into set type(tname) values(#{tname})")
    public int insert(TypeBean type);

    @Select("select tid,tname from type where tname like (#{tname})")
    public TypeBean selectByName(TypeBean type);

    //public TypeBean
}
