package com.shiweile.mapper;

import com.shiweile.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {

@Select("select * from tb_goods")
    List<Goods> selectAll();

@Insert("insert into tb_goods values (null,#{name},#{number},#{wait},#{storeHouse},#{type},#{company})")
    void addGoods(Goods goods);

@Delete("delete from tb_goods where id=#{id}")
    void deleteGoods(int id);

@Update("update tb_goods set name=#{name},number=#{number},wait=#{wait},storehouse=#{storeHouse},type=#{type},company=#{company} where id=#{id}")
    void updateGoods(Goods goods);


@Select("select * from tb_goods limit #{begin},#{size}")
    List<Goods> selectByPage(@Param("begin") int begin,@Param("size") int size);

@Select("select Count(*) from tb_goods")
    int selectTotalCount();

    List<Goods> selectByPageAndC(@Param("begin")int begin,@Param("size")int size,@Param("goods")Goods goods);


    int selectTotalCountAndC(Goods goods);


    void deleteByIds(@Param("ids")int[] ids);
}


