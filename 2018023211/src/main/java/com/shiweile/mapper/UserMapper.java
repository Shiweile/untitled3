package com.shiweile.mapper;

import com.shiweile.pojo.Goods;
import com.shiweile.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from tb_user where username=#{username}")
    User selectByUsername(String username);

    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

    @Insert("insert into tb_user values (null,#{name},#{username},#{password},#{department},#{position})")
    void add(User user);

    List<User> selectByPageAndC(@Param("begin")int begin, @Param("size")int size, @Param("user")User user);

    int selectTotalCountAndC(User user);

    @Insert("insert into tb_user values (null,#{name},#{username},#{password},#{department},#{position})")
    void addUser(User user);

    @Update("update tb_user set name=#{name},username=#{username},password=#{password},department=#{department},position=#{position} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from tb_user where id=#{id}")
    void deleteUser(int id);

    void deleteByIds(@Param("ids")int[] ids);
}
