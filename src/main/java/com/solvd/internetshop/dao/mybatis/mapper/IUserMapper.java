package com.solvd.internetshop.dao.mybatis.mapper;

import com.solvd.internetshop.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IUserMapper {
    @Select("SELECT * WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age")
    })
    User getUserById(int id);



    @Insert("INSERT INTO User (firstName, lastName, phone, password, email, age)" +
            " VALUES (#{firstName},#{lastName}, #{phone}, #{password}, #{email}, #{age},)")
    void insertUser(User user);
}
