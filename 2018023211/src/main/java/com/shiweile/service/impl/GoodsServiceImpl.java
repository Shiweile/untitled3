package com.shiweile.service.impl;

import com.shiweile.mapper.GoodsMapper;
import com.shiweile.pojo.Goods;
import com.shiweile.pojo.goodsBean;
import com.shiweile.service.GoodsService;
import com.shiweile.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
private SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public List<Goods> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = mapper.selectAll();
        sqlSession.close();
        return goods;
    }

    @Override
    public void addGoods(Goods goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.addGoods(goods);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteGoods(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.deleteGoods(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateGoods(Goods goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.updateGoods(goods);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public goodsBean selectByPage(int begin, int size) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> g = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();
        goodsBean goodsBean=new goodsBean<>();
        goodsBean.setRows(g);
        goodsBean.setTotalCount(totalCount);
        return goodsBean;
    }

    @Override
    public goodsBean selectByPageAndC(int begin, int size, Goods goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);

        List<Goods> g = mapper.selectByPageAndC(begin,size,goods);

        int totalCount = mapper.selectTotalCountAndC(goods);
        goodsBean goodsBean=new goodsBean<>();
        goodsBean.setRows(g);
        goodsBean.setTotalCount(totalCount);
        return goodsBean;
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
