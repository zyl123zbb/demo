package com.example.demo.Dao;

import com.example.demo.Bean.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDAO {
    /**
     * 根据用户名进行查询
     * @param username
     * @return
     */
    @Select("select id,username,upassword from users where username=#{username}")
    public UserBean selectByUsername(String username);

    /**
     * 根据用户名和密码进行查询
     * @param username
     * @param upassword
     * @return
     */
    @Select("select id,username,upassword from users where username=#{username} and upassword=#{upassword}")
    public UserBean selectByUserAndPassword(String username,String upassword);
    //通过用户和密码只能查询到一条记录

    /**
     * 添加数据
     * @param userBean
     * @return
     */
    @Insert("insert into users (id,username,upassword) values (#{id},#{username},#{upassword})")
    public int insert(UserBean userBean);

    /**
     * 根据id对密码进行修改
     * @param userBean
     * @return
     */
    @Update("update users set upassword=#{upassword} where id=#{id}")
    public int update(UserBean userBean);

    /**
     * 根据id对用户名进行修改
     * @param userBean
     * @return
     */
    @Update("update users set username=#{username} where id=#{id}")
    public int update1(UserBean userBean);

    /**
     * 删除数据
     * @param id
     * @return
     */
    @Delete("delete from users where id=#{id}")
    public int delete(Integer id);
}
