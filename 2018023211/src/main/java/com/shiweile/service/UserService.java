package com.shiweile.service;

import com.shiweile.pojo.Goods;
import com.shiweile.pojo.User;
import com.shiweile.pojo.goodsBean;
import com.shiweile.pojo.userBean;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User selectByUsername(String username);

    User login(String username,String password);

    boolean register(User user);

    userBean selectByPageAndC(int begin, int size, User user);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    void deleteByIds(int[] ids);
}
