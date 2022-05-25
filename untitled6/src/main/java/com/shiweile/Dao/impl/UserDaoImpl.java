package com.shiweile.Dao.impl;

import com.shiweile.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("sava");
    }

    public void update() {
        System.out.println("update");
    }
}
