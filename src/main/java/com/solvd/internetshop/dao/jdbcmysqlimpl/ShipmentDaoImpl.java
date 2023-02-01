package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IShipmentDao;
import com.solvd.internetshop.model.Shipment;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;

public class ShipmentDaoImpl implements IShipmentDao {

    private Shipment shipment = new Shipment();
    private  List<Shipment> shipments = new ArrayList<>();




    @Override
    public Shipment getEntityById(int id) {
        String query = "SELECT * FROM Shipment WHERE id = ?";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                String status = resultSet.getString("status");
                String transportName = resultSet.getString("transportName");
                String date = resultSet.getString("date");
                shipment = new Shipment (id, status, transportName, date);
            }

            resultSet.close();
            return shipment;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertEntity(Shipment shipment) {

        String insertQuery =
                "INSERT INTO Shipment (status, transportName, date) VALUES (?, ?, ?)";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)) {

            preparedStatement.setString(1, shipment.getStatus());
            preparedStatement.setString(2, shipment.getTransportName());
            preparedStatement.setString(3, shipment.getDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEntity(Shipment shipment) {

        String query = "UPDATE Shipment SET status= ?, transportName= ?, date= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, shipment.getStatus());
            preparedStatement.setString(2, shipment.getTransportName());
            preparedStatement.setString(3, shipment.getDate());
            preparedStatement.setInt(4, shipment.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Shipment WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Shipment> getAllShipments() {

        String query = "SELECT * FROM Shipment";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                shipments.add(new Shipment(resultSet.getInt("id"),
                                           resultSet.getString("status"),
                                           resultSet.getString("transportName"),
                                           resultSet.getString("date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipments;

    }

    public static void main(String[] args) {
        IShipmentDao iShipmentDao = new ShipmentDaoImpl();
        List<Shipment> userRoles = iShipmentDao.getAllShipments();
        System.out.println(userRoles);
    }

}
