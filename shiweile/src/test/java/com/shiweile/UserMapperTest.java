package com.shiweile;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiweile.mapper.UserMapper;
import com.shiweile.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void selectByIdTest(){
        User user = (User) userMapper.selectById(1000);
        System.out.println(user);
    }

    @Test
    void selectByIdsTest(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1000,1001));
        System.out.println(users);
    }

    @Test
    void selectByMap(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

    }

    @Test
    void selectByPageAndC(){
        IPage page = new Page(2,3);
        User user = new User();
        user.setId(1007);


        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        wrapper.select(User::getId,User::getPosition,User::getName).lt(User::getId,user.getId());
        userMapper.selectPage(page,wrapper);
    }

    @Test
    void selectByPage(){
        IPage page = new Page(1,3);



    }
}
