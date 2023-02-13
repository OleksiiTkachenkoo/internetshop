package com.solvd.internetshop.dao.mybatis;

import com.solvd.internetshop.dao.mybatis.service.AddressService;
import com.solvd.internetshop.dao.mybatis.service.InvoiceService;
import com.solvd.internetshop.dao.mybatis.service.UserRoleService;
import com.solvd.internetshop.dao.mybatis.service.UserService;
import com.solvd.internetshop.model.Address;
import com.solvd.internetshop.model.Invoice;
import com.solvd.internetshop.model.User;
import com.solvd.internetshop.model.UserRole;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();
        UserRoleService userRoleService = new UserRoleService();
//        User user = userService.getUserById(15);
//        System.out.println(user);
//        user.setLastName("Maks");
//        userService.updateUser(user);
//        System.out.println(user);

//
//        User user1 = new User("Drew", "Dallas", "+380931668949",
//                              "dallas192sm", "dash@gmail.com", 90);
//
//        User user2 = new User("Drew", "Dallas", "+380931668949",
//                "dallas192sm", "dash@gmail.com", 90);



//        userService.removeUserById(32);
//
//        System.out.println(userService.getAllUsers());

//        UserRole userRole = userRoleService.getUserRoleById(5);
//        System.out.println(userRole);
//        userRole.setRole("Bro");
//        userRoleService.updateUserRole(userRole);

//        userRoleService.insertUserRole(new UserRole("Clown"));
//        Address address = new AddressService().getAddressById(3);
//        System.out.println(address);

        Invoice invoice = new InvoiceService().getInvoiceById(1);
        System.out.println(invoice);

    }

}
