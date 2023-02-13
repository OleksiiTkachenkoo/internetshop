package com.solvd.internetshop.dao.mybatis.mapper;


import com.solvd.internetshop.model.Invoice;

import java.util.List;

public interface IInvoiceMapper {

    void updateInvoice(Invoice invoice);

    Invoice getInvoiceById(int id);

    List<Invoice> getAllInvoices();

    void insertInvoice(Invoice invoice);

    void removeInvoiceById(int id);
}
