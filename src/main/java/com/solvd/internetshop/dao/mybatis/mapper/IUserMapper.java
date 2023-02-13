package com.solvd.internetshop.dao.mybatis.mapper;

import com.solvd.internetshop.model.User;

import java.util.List;

public interface IUserMapper {

    void updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void insertUser(User user);

    void removeUserById(int id);
}
