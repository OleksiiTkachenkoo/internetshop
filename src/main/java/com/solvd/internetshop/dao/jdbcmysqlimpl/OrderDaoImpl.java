package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IOrderDao;
import com.solvd.internetshop.model.Order;
import com.solvd.internetshop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;
import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class OrderDaoImpl implements IOrderDao {

    private Order order = new Order();
    private List<Order> orders = new ArrayList<>();




    @Override
    public Order getEntityById(int id) {

        String query = "SELECT * FROM Order WHERE id = ?";

        try (
                Connection connection = getApacheDbConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                order = getOrderFromResultSet(resultSet);

            }

            resultSet.close();
            return order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void insertEntity(Order order) {

        String insertQuery =
                "INSERT INTO Order (creationDate, status, description, idUser, idPayment)" +
                        " VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection = getApacheDbConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(insertQuery)
        ) {

            preparedStatement.setString(1, order.getCreationDate());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setString(3, order.getDescription());
            preparedStatement.setInt(4, order.getIdUser());
            preparedStatement.setInt(5, order.getIdPayment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }
    }

    @Override
    public void updateEntity(Order order) {

        String query = "UPDATE Order SET creationDate= ?, status= ?, " +
                " description= ?, idUser= ?, idPayment= ? WHERE id= ?";

        try(
                Connection connection = getApacheDbConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, order.getCreationDate());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setString(3, order.getDescription());
            preparedStatement.setInt(6, order.getIdUser());
            preparedStatement.setInt(7, order.getIdPayment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Order WHERE id= ?";

        try(
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
    public  List<Order> getAllOrders() {

        String query = "SELECT * FROM Order";

        try(
                Connection connection = getApacheDbConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {
                orders.add(getOrderFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            myLogger().error(e);
        }
        return orders;
    }

    private Order getOrderFromResultSet(ResultSet resultSet) throws SQLException {
        Order o = new Order();
        o.setId(resultSet.getInt("id"));
        o.setCreationDate(resultSet.getString("creationDate"));
        o.setStatus(resultSet.getString("status"));
        o.setDescription(resultSet.getString("description"));
        o.setIdUser(resultSet.getInt("idUser"));
        o.setIdPayment(resultSet.getInt("idPayment"));
        return o;
    }

}
