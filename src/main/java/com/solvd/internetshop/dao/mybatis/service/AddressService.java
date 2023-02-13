package com.solvd.internetshop.dao.mybatis.service;

import com.solvd.internetshop.dao.mybatis.mapper.IAddressMapper;
import com.solvd.internetshop.dao.mybatis.util.MyBatisUtil;
import com.solvd.internetshop.model.Address;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressService {

    public Address getAddressById(int addressId) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IAddressMapper addressMapper = sqlSession.getMapper(IAddressMapper.class);
            return addressMapper.getAddressById(addressId);
        }
    }

    public void insertAddress(Address address) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IAddressMapper addressMapper = sqlSession.getMapper(IAddressMapper.class);
            addressMapper.insertAddress(address);
            sqlSession.commit();
        }
    }

    public List<Address> getAllAddresses() {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IAddressMapper addressMapper = sqlSession.getMapper(IAddressMapper.class);
            return addressMapper.getAllAddresses();
        }
    }

    public void removeAddressById(int id) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IAddressMapper addressMapper = sqlSession.getMapper(IAddressMapper.class);
            addressMapper.removeAddressById(id);
            sqlSession.commit();
        }
    }

    public void updateAddress(Address address) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IAddressMapper addressMapper = sqlSession.getMapper(IAddressMapper.class);
            addressMapper.updateAddress(address);
            sqlSession.commit();
        }
    }
}
