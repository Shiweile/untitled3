package com.shiweile.Service.impl;

import com.shiweile.Dao.UserDao;
import com.shiweile.Dao.impl.UserDaoImpl;
import com.shiweile.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//<bean id="userService" class="com.shiweile.Service.impl.UserServiceImpl">
//<constructor-arg name="userDao" ref="userDao"></constructor-arg>
//</bean>

//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserDao userDao) {

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


    public void save() {

        userDao.save();

    }
}
