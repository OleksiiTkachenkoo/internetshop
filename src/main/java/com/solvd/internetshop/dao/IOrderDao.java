package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Account;
import com.solvd.internetshop.model.Order;

import java.util.List;

public interface IOrderDao extends IBaseDao<Order> {
    List<Order> getAllOrders();
}
