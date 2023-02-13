package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IProductDao;
import com.solvd.internetshop.model.Account;
import com.solvd.internetshop.model.Product;
import com.solvd.internetshop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;
import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class ProductDaoImpl implements IProductDao {
    Product product = new Product();
    List<Product> products = new ArrayList<>();

    @Override
    public Product getEntityById(int id) {

        String query = "SELECT * FROM Product WHERE id = ?";

        try (
                Connection connection = getApacheDbConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                product = getProductFromResultSet(resultSet);

            }

            resultSet.close();
            return product;

        } catch (SQLException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertEntity(Product product) {

        String insertQuery =
                "INSERT INTO Product (title, price, categories, idUser, idCart, availability, quantity)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = getApacheDbConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(insertQuery)
        ) {

            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getCategories());
            preparedStatement.setInt(4, product.getIdUser());
            preparedStatement.setInt(5, product.getIdCart());
            preparedStatement.setString(6, product.getAvailability());
            preparedStatement.setInt(7, product.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }
    }

    @Override
    public void updateEntity(Product product) {

        String query = "UPDATE Product SET firstName= ?, lastName= ?, " +
                " phone= ?, password= ?, email= ?, age= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getCategories());
            preparedStatement.setInt(4, product.getIdUser());
            preparedStatement.setInt(5, product.getIdCart());
            preparedStatement.setString(6, product.getAvailability());
            preparedStatement.setInt(7, product.getQuantity());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }
    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Product WHERE id= ?";

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
    public List<Product> getAllProducts() {

        String query = "SELECT * FROM Product";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                products.add(getProductFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            myLogger().error(e);
        }
        return products;
    }

    private Product getProductFromResultSet(ResultSet resultSet) throws SQLException {
        Product p = new Product();
        p.setId(resultSet.getInt("id"));
        p.setTitle(resultSet.getString("title"));
        p.setPrice(resultSet.getInt("price"));
        p.setCategories(resultSet.getString("categories"));
        p.setIdUser(resultSet.getInt("idUser"));
        p.setIdCart(resultSet.getInt("idCart"));
        p.setAvailability(resultSet.getString("availability"));
        p.setQuantity(resultSet.getInt("quantity"));
        return p;
    }

    public static void main(String[] args) {

        IProductDao iProductDao = new ProductDaoImpl();
        Product product = new Product("Dreadbox Typhon",2220,
                                 "synthesizer", "available", 30);

        iProductDao.insertEntity(product);
        List<Product> products = iProductDao.getAllProducts();
        System.out.println(products);
    }


}
