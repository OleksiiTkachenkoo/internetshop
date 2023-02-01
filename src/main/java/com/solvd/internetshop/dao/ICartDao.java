package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Cart;
import com.solvd.internetshop.model.User;

import java.util.List;

public interface ICartDao extends IBaseDao<Cart> {
    List<Cart> getAllCartInformation();

}
