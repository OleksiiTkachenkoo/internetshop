package com.solvd.internetshop.dao.mybatis.service;


import com.solvd.internetshop.dao.mybatis.mapper.IUserRoleMapper;
import com.solvd.internetshop.dao.mybatis.util.MyBatisUtil;
import com.solvd.internetshop.model.UserRole;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserRoleService {

    public UserRole getUserRoleById(int userId) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserRoleMapper userRoleMapper = sqlSession.getMapper(IUserRoleMapper.class);
            return userRoleMapper.getUserRoleById(userId);
        }
    }

    public void insertUserRole(UserRole userRole) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserRoleMapper userRoleMapper = sqlSession.getMapper(IUserRoleMapper.class);
            userRoleMapper.insertUserRole(userRole);
            sqlSession.commit();
        }
    }

    public List<UserRole> getAllUserRoles() {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserRoleMapper userRoleMapper = sqlSession.getMapper(IUserRoleMapper.class);
            return userRoleMapper.getAllUserRoles();
        }
    }

    public void removeUserRoleById(int id) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserRoleMapper userRoleMapper = sqlSession.getMapper(IUserRoleMapper.class);
            userRoleMapper.removeUserRoleById(id);
            sqlSession.commit();
        }
    }

    public void updateUserRole(UserRole userRole) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserRoleMapper userRoleMapper = sqlSession.getMapper(IUserRoleMapper.class);
            userRoleMapper.updateUserRole(userRole);
            sqlSession.commit();
        }
    }
}
