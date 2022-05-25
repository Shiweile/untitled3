package com.shiweile.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tb_user1")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String department;
    private String name;
    private String position;

}
