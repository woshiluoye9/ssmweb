package com.dustin.dao.mapper;


import com.dustin.dao.object.User;

public interface UserMapper {

    //通过 id 查询用户
    User queryUserById(int id);
}