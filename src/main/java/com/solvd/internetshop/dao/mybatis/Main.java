package com.solvd.internetshop.dao.mybatis;

import com.solvd.internetshop.dao.mybatis.service.UserService;
import com.solvd.internetshop.model.User;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();

        User user = userService.getUserById(15);
        System.out.println(user);

        User user1 = new User("Andrew", "Dallas", "+380931668949",
                              "dallas192sm", "dash@gmail.com", 90);
        userService.insertUser(user1);

    }

}
