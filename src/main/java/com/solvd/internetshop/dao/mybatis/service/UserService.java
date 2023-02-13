package com.solvd.internetshop.dao.mybatis.service;

import com.solvd.internetshop.dao.mybatis.util.MyBatisUtil;
import com.solvd.internetshop.dao.mybatis.mapper.IUserMapper;
import com.solvd.internetshop.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;




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

    public List<User> getAllUsers() {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            return userMapper.getAllUsers();
        }
    }

    public void removeUserById(int id) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            userMapper.removeUserById(id);
            sqlSession.commit();
        }
    }

    public void updateUser(User user) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            userMapper.updateUser(user);
            sqlSession.commit();
        }

    }

}
