package com.shiweile.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiweile.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
