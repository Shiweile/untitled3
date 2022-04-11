package com.shiweile.service.impl;

import com.shiweile.mapper.GoodsMapper;
import com.shiweile.mapper.UserMapper;
import com.shiweile.pojo.Goods;
import com.shiweile.pojo.User;
import com.shiweile.pojo.goodsBean;
import com.shiweile.pojo.userBean;
import com.shiweile.service.UserService;
import com.shiweile.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory();
    @Override
    public User selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }

    @Override
    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.login(username, password);
        sqlSession.close();
        return user;
    }

    @Override
    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(user.getusername());
        if (u==null){
            //用户不存在可以注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;
    }

    @Override
    public userBean selectByPageAndC(int begin, int size, User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> g = mapper.selectByPageAndC(begin,size,user);

        int totalCount = mapper.selectTotalCountAndC(user);
        userBean userBean=new userBean<>();
        userBean.setRows(g);
        userBean.setTotalCount(totalCount);
        return userBean;
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }


}
