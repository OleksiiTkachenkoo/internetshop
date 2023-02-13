package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IAddressDao;
import com.solvd.internetshop.model.Address;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;
import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class AddressDaoImpl implements IAddressDao {

    private Address address = new Address();
    private  List<Address> addresses = new ArrayList<>();


    @Override
    public Address getEntityById(int id) {

        String query = "SELECT * FROM Address WHERE id = ?";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                address = getAddressFromResultSet(resultSet);

            }

            resultSet.close();
            return address;

        } catch (SQLException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertEntity(Address address) {

        String insertQuery =
                "INSERT INTO Address (country, city, street, " +
                        "apartment, idUser, idShipment) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)) {

            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getApartment());
            preparedStatement.setInt(5, address.getIdUser());
            preparedStatement.setInt(6, address.getIdShipment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEntity(Address address) {

        String query = "UPDATE Address SET country= ?, city= ?, street= ?, " +
                " apartment= ?, idUser= ?, idShipment= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getApartment());
            preparedStatement.setInt(5, address.getIdUser());
            preparedStatement.setInt(6, address.getIdShipment());
            preparedStatement.setInt(7, address.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Address WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public List<Address> getAllAddresses() {

        String query = "SELECT * FROM Address";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                addresses.add(getAddressFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            myLogger().error(e);
        }
        return addresses;
    }

    private Address getAddressFromResultSet(ResultSet resultSet) throws SQLException {
        Address a = new Address();
        a.setId(resultSet.getInt("id"));
        a.setCountry(resultSet.getString("country"));
        a.setCity(resultSet.getString("city"));
        a.setStreet(resultSet.getString("street"));
        a.setApartment(resultSet.getString("apartment"));
        a.setIdUser(resultSet.getInt("idUser"));
        a.setIdShipment(resultSet.getInt("idShipment"));
        return a;
    }

    public static void main(String[] args) {
        
    }
}
