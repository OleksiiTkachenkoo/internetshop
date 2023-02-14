package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IInvoiceDao;
import com.solvd.internetshop.model.Invoice;
import com.solvd.internetshop.model.Shipment;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;
import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class InvoiceDaoImpl implements IInvoiceDao {

    private Invoice invoice = new Invoice();
    private  List<Invoice> invoices = new ArrayList<>();


    @Override
    public Invoice getEntityById(int id) {

        String query = "SELECT * FROM Invoice WHERE id = ?";

        try (
             Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                invoice =  getInvoiceFromResultSet(resultSet);
            }

            resultSet.close();
            return invoice;

        } catch (SQLException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertEntity(Invoice invoice) {

        String insertQuery = "INSERT INTO Invoice (invoiceDate, statusPaid) VALUE (?, ?)";

        try (
             Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)
        ) {

            preparedStatement.setString(1, invoice.getInvoiceDate());
            preparedStatement.setString(2, invoice.getStatusPaid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }


    }

    @Override
    public void updateEntity(Invoice invoice) {

        String query = "UPDATE Invoice SET invoiceDate= ?, statusPaid= ?  WHERE id= ?";

        try (
            Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, invoice.getInvoiceDate());
            preparedStatement.setString(2, invoice.getStatusPaid());
            preparedStatement.setInt(3, invoice.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Invoice WHERE id= ?";

        try (
            Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public List<Invoice> getAllInvoices() {

        String query = "SELECT * FROM Invoice";

        try (
            Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {

                invoices.add(getInvoiceFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            myLogger().error(e);
        }
        return invoices;
    }

    private Invoice getInvoiceFromResultSet(ResultSet resultSet) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(resultSet.getInt("id"));
        invoice.setInvoiceDate(resultSet.getString("invoiceDate"));
        invoice.setStatusPaid(resultSet.getString("statusPaid"));
        return invoice;
    }

    public static void main(String[] args) {
        IInvoiceDao iInvoiceDao = new InvoiceDaoImpl();
        Invoice invoice = iInvoiceDao.getEntityById(2);

        invoice.setInvoiceDate("0000-00-00");
        invoice.setStatusPaid("paid");
        iInvoiceDao.updateEntity(invoice);
//        iInvoiceDao.setEntity(new Invoice("1111-11-11", "unpaid"));
        iInvoiceDao.removeEntityById(4);


        List<Invoice> invoices = iInvoiceDao.getAllInvoices();
        System.out.println(invoices);

    }

}
