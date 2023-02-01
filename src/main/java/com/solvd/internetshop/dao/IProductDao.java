package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Product;

import java.util.List;

public interface IProductDao extends IBaseDao<Product> {
    List<Product> getAllProducts();
}
