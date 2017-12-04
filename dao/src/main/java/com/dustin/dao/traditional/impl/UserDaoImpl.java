package com.dustin.dao.traditional.impl;

import com.dustin.dao.object.User;
import com.dustin.dao.traditional.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * <p> Description: </p>
 *
 * @author Wangsw
 * @date 2017/11/23下午 08:17
 * @Version 1.0.0
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    public User queryUserById(int id) throws Exception {
        //继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSessoin
        SqlSession sqlSession = this.getSqlSession();

        User user = sqlSession.selectOne("com.dustin.dao.UserMapper.queryUserById", id);
        return user;
    }
}
