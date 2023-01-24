package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IUserDao;
import com.solvd.internetshop.model.User;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;


public class UserDaoImpl implements IUserDao {

    private  User user = new User();
    private  List<User> users = new ArrayList<>();




    @Override
    public User getEntityById(int id) {

        String query = "SELECT * FROM User WHERE id = ?";

        try (Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");

                user =  new User (id, firstName, lastName, phone, password, email, age);
            }

            resultSet.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        @Override
    public void setEntity(User user) {
        String insertQuery =
                    "INSERT INTO User (firstName, lastName, phone, password, email, age)" +
                            " VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(User user) {

        String query = "UPDATE User SET firstName= ?, lastName= ?, " +
                                      " phone= ?, password= ?, email= ?, age= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.setInt(7, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM User WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  List<User> getAllUsers() {

        String query = "SELECT * FROM User";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                                   resultSet.getString("firstName"),
                                   resultSet.getString("lastName"),
                                   resultSet.getString("phone"),
                                   resultSet.getString("password"),
                                   resultSet.getString("email"),
                                   resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        IUserDao userDaoImpl = new UserDaoImpl();
        User user =  userDaoImpl.getEntityById(28);
        user.setFirstName("Anatoliy");
        user.setLastName("Tapolskiy");
        userDaoImpl.updateEntity(user);
//        userDaoImpl.setEntity(new User("Andrew", "Dallas", "+380931668949", "dallas192sm", "dash@gmail.com", 90));
//        userDaoImpl.removeEntityById(19);

        List<User> users = userDaoImpl.getAllUsers();
        System.out.println(users);

    }
}
