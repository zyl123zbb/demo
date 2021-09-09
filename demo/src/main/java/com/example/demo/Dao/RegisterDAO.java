package com.example.demo.Dao;

import com.example.demo.Bean.RegisterBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RegisterDAO {
    /**
     * 根据用户名进行查询
     * @param username
     * @return
     */
    @Select("select id,username,upassword,email from users where username=#{username}")
    public RegisterBean selectByUsername(String username);

    /**
     * 根据用户名和密码进行查询
     * @param username
     * @param upassword
     * @return
     */
    @Select("select id,username,upassword,email from users where username=#{username} and upassword=#{upassword}")
    public RegisterBean selectByUserAndPassword(String username,String upassword);

    @Select("select id,username,upassword,email from users where email=#{email}")
    public RegisterBean selectByEmail(String email);
    //通过用户和密码只能查询到一条记录

    /**
     * 添加数据
     * @param reegisterBean
     * @return
     */
    @Insert("insert into users (id,username,upassword,email) values (#{id},#{username},#{upassword},#{email})")
    public int insert(RegisterBean reegisterBean);

    /**
     * 根据id对密码进行修改
     * @param reegisterBean
     * @return
     */
    @Update("update users set upassword=#{upassword} where id=#{id}")
    public int update(RegisterBean reegisterBean);

    /**
     * 根据id对用户名进行修改
     * @param reegisterBean
     * @return
     */
    @Update("update users set username=#{username} where id=#{id}")
    public int update1(RegisterBean reegisterBean);

    @Update("update users set email=#{email} where id=#{id}")
    public  int update2(RegisterBean reegisterBean);
    /**
     * 删除数据
     * @param id
     * @return
     */
    @Delete("delete from users where id=#{id}")
    public int delete(Integer id);
}
