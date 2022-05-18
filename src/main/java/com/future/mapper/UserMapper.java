package com.future.mapper;

import com.future.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    //这里的空值问题我要着重标注一下：
    //1、你在User类中定义的id一定要是Integer类而不能是String类
    //2、你数据表中的id字段一定要设置成自增(auto_increment)的
    @Insert("insert into user values(null,#{username},#{password})")
    void add(User user);
}
