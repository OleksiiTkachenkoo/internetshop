package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Address;


import java.util.List;

public interface IAddressDao extends IBaseDao<Address> {
    List<Address> getAllAddresses();
}
