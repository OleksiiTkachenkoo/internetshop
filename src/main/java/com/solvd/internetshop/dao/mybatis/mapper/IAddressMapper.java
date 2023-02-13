package com.solvd.internetshop.dao.mybatis.mapper;

import com.solvd.internetshop.model.Address;


import java.util.List;

public interface IAddressMapper {

    void updateAddress(Address address);

    Address getAddressById(int id);

    List<Address> getAllAddresses();

    void insertAddress(Address address);

    void removeAddressById(int id);
}
