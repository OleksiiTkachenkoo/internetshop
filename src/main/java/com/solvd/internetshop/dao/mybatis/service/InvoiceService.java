package com.solvd.internetshop.dao.mybatis.service;


import com.solvd.internetshop.dao.mybatis.mapper.IInvoiceMapper;
import com.solvd.internetshop.dao.mybatis.util.MyBatisUtil;
import com.solvd.internetshop.model.Invoice;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class InvoiceService {

    public Invoice getInvoiceById(int invoiceId) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IInvoiceMapper invoiceMapper = sqlSession.getMapper(IInvoiceMapper.class);
            return invoiceMapper.getInvoiceById(invoiceId);
        }
    }

    public void insertInvoice(Invoice invoice) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IInvoiceMapper invoiceMapper = sqlSession.getMapper(IInvoiceMapper.class);
            invoiceMapper.insertInvoice(invoice);
            sqlSession.commit();
        }
    }

    public List<Invoice> getAllInvoices() {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IInvoiceMapper invoiceMapper = sqlSession.getMapper(IInvoiceMapper.class);
            return invoiceMapper.getAllInvoices();
        }
    }

    public void removeInvoiceById(int id) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IInvoiceMapper invoiceMapper = sqlSession.getMapper(IInvoiceMapper.class);
            invoiceMapper.removeInvoiceById(id);
            sqlSession.commit();
        }
    }

    public void updateAddress(Invoice invoice) {

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IInvoiceMapper invoiceMapper = sqlSession.getMapper(IInvoiceMapper.class);
            invoiceMapper.updateInvoice(invoice);
            sqlSession.commit();
        }
    }
}
