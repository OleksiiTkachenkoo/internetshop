package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Invoice;

import java.util.List;

public interface IInvoiceDao extends IBaseDao<Invoice>{
    List<Invoice> getAllInvoices();
}
