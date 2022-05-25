package com.shiweile.Dao.impl;

import com.shiweile.Dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.shiweile.Dao.impl.UserDaoImpl"></bean>
@Component("userDao")
//@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save run");
    }
}
