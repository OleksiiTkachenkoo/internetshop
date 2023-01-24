package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.UserRole;


import java.util.List;

public interface IUserRoleDao extends IBaseDao<UserRole> {
    List<UserRole> getAllUserRoles();
}
