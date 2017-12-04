package com.dustin.service;

import com.dustin.dao.object.User;

/**
 * <p> Description: </p>
 *
 * @author Wangsw
 * @date 2017/11/26下午 08:53
 * @Version 1.0.0
 */
public interface UserService {
    User queryUserById(int id);
}
