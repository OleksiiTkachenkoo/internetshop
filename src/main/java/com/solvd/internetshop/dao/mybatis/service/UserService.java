package com.solvd.internetshop.dao.mybatis.service;

import com.solvd.internetshop.dao.mybatis.util.MyBatisUtil;
import com.solvd.internetshop.dao.mybatis.mapper.IUserMapper;
import com.solvd.internetshop.model.User;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    public User getUserById(int userId) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            return userMapper.getUserById(userId);
        }
    }

    public void insertUser(User user) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            userMapper.insertUser(user);
            sqlSession.commit();

        }
    }
}
