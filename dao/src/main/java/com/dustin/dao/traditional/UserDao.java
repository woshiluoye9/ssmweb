package com.dustin.dao.traditional;

import com.dustin.dao.object.User;

/**
 * <p> Description: </p>
 *
 * @author Wangsw
 * @date 2017/11/23下午 08:15
 * @Version 1.0.0
 */
public interface UserDao {
    //根据id查询用户信息
    public User queryUserById(int id) throws Exception;
}
