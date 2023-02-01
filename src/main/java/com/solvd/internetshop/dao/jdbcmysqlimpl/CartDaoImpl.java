package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.ICartDao;

import com.solvd.internetshop.model.Cart;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;

public class CartDaoImpl implements ICartDao {

    private Cart cart = new Cart();
    private  List<Cart> carts = new ArrayList<>();


    @Override
    public Cart getEntityById(int id) {

        String query = "SELECT * FROM Cart WHERE id = ?";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                String productItem = resultSet.getString("productItem");
                String dateAdd = resultSet.getString("dateAdd");

                cart =  new Cart (id, productItem, dateAdd);
            }

            resultSet.close();
            return cart;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertEntity(Cart cart) {

        String insertQuery =
                "INSERT INTO Cart (productItem, dateAdd)" +
                        " VALUES (?, ?)";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)) {

            preparedStatement.setString(1, cart.getProductItem());
            preparedStatement.setString(2, cart.getDateAdd());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(Cart cart) {
        String query = "UPDATE Cart SET productItem= ?, dateAdd= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cart.getProductItem());
            preparedStatement.setString(2, cart.getDateAdd());
            preparedStatement.setInt(3, cart.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Cart WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> getAllCartInformation() {

        String query = "SELECT * FROM Cart";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                carts.add(new Cart(resultSet.getInt("id"),
                        resultSet.getString("productItem"),
                        resultSet.getString("dateAdd")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }

    public static void main(String[] args) {
        ICartDao cartDaoImpl = new CartDaoImpl();
        Cart cart = new Cart("Model D", "2023-22-13");
        cartDaoImpl.insertEntity(cart);
        List<Cart> carts = cartDaoImpl.getAllCartInformation();
        System.out.println(carts);
    }

}
