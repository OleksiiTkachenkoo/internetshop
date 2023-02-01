package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IProductDao;
import com.solvd.internetshop.model.Product;
import com.solvd.internetshop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;

public class ProductDaoImpl implements IProductDao {

    List<Product> products = new ArrayList<>();

    @Override
    public Product getEntityById(int id) {
        return null;
    }

    @Override
    public void insertEntity(Product product) {

        String insertQuery =
                "INSERT INTO Product (title, price, categories, availability, quantity)" +
                        " VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getCategories());
//            preparedStatement.setInt(4, product.getIdOrder());
//            preparedStatement.setInt(5, product.getIdCart());
            preparedStatement.setString(6, product.getAvailability());
            preparedStatement.setInt(7, product.getQuantity());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()) {
                product.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        String insertProductQuery
//                = "INSERT INTO products (name, price) VALUES (?, ?);";
//        try (Connection connection = ConnectionUtil.getConnection();
//             PreparedStatement statement =
//                     connection.prepareStatement(insertProductQuery,
//                             Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, product.getName());
//            statement.setDouble(2, product.getPrice());
//            statement.executeUpdate();
//            ResultSet resultSet = statement.getGeneratedKeys();
//            if (resultSet.next()) {
//                product.setId(resultSet.getLong(1));
//            }
//            return product;
    }

    @Override
    public void updateEntity(Product product) {

    }

    @Override
    public void removeEntityById(int id) {

    }


    @Override
    public List<Product> getAllProducts() {

        String query = "SELECT * FROM Product";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("price"),
                        resultSet.getString("categories"),
                        resultSet.getInt("idOrder"),
                        resultSet.getInt("idCart"),
                        resultSet.getString("availability"),
                        resultSet.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
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
