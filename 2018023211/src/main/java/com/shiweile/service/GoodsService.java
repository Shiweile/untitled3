package com.shiweile.service;

import com.shiweile.pojo.Goods;
import com.shiweile.pojo.goodsBean;

import java.util.List;

public interface GoodsService {
    List<Goods> selectAll();

    void addGoods(Goods goods);

    void deleteGoods(int id);

    void updateGoods(Goods goods);

    goodsBean selectByPage(int begin,int size);

    goodsBean selectByPageAndC(int begin,int size,Goods goods);

    void deleteByIds(int[] ids);
}
