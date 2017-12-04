package com.dustin.service.impl;

import com.dustin.dao.mapper.UserMapper;
import com.dustin.dao.object.User;
import com.dustin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> Description: </p>
 *
 * @author Wangsw
 * @date 2017/11/26下午 08:40
 * @Version 1.0.0
 */
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(int id){
        User user = userMapper.queryUserById(id);
        return user;
    }
}
