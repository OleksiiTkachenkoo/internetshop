package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User> {
    List<User> getAllUsers();
}
