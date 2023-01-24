package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IAddressDao;
import com.solvd.internetshop.model.Address;
import com.solvd.internetshop.model.Invoice;
import com.solvd.internetshop.model.Shipment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;

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

                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String apartment = resultSet.getString("apartment");
                int idUser = resultSet.getInt("");
                int idShipment = resultSet.getInt("idShipment");

                address = new Address(id, country, city, street, apartment, idUser, idShipment);
            }

            resultSet.close();
            return address;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setEntity(Address address) {

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
            e.printStackTrace();
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
            e.printStackTrace();
        }

    }

    @Override
    public List<Address> getAllAddresses() {

        String query = "SELECT * FROM Address";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                addresses.add(new Address(resultSet.getInt("id"),
                                          resultSet.getString("country"),
                                          resultSet.getString("city"),
                                          resultSet.getString("street"),
                                          resultSet.getString("apartment"),
                                          resultSet.getInt("idUser"),
                                          resultSet.getInt("idShipment")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }
}
