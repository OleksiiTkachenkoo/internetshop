package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Account;


import java.util.List;

public interface IAccountDao extends IBaseDao<Account> {
    List<Account> getAllAccounts();
}
