package com.shiweile;

import com.shiweile.Config.SpringConfig;
import com.shiweile.Dao.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = app.getBean(UserDao.class);
        userDao.update();
    }

}
