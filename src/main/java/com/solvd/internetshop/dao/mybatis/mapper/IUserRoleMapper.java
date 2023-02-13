package com.solvd.internetshop.dao.mybatis.mapper;


import com.solvd.internetshop.model.UserRole;

import java.util.List;

public interface IUserRoleMapper {

    void updateUserRole(UserRole userRole);

    UserRole getUserRoleById(int id);

    List<UserRole> getAllUserRoles();

    void insertUserRole(UserRole userRole);

    void removeUserRoleById(int id);
}
