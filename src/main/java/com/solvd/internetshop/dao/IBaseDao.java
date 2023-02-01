package com.solvd.internetshop.dao;

public interface IBaseDao<T> {
    T getEntityById(int id);
    void insertEntity(T t);
    void updateEntity(T t);
    void removeEntityById(int id);
}
