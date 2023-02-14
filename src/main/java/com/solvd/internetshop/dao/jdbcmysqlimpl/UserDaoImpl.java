package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IUserDao;
import com.solvd.internetshop.model.User;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;
import static com.solvd.internetshop.logger.MyLogger.myLogger;


public class UserDaoImpl implements IUserDao {

    private  User user = new User();
    private  List<User> users = new ArrayList<>();




    @Override
    public User getEntityById(int id) {

        String query = "SELECT * FROM User WHERE id = ?";

        try (
            Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection
                     .prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                user = getUserFromResultSet(resultSet);

            }

            resultSet.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void insertEntity(User user) {

        String insertQuery =
                    "INSERT INTO User (firstName, lastName, phone, password, email, age)" +
                            " VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)
        ) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }
    }

    @Override
    public void updateEntity(User user) {

        String query = "UPDATE User SET firstName= ?, lastName= ?, " +
                                      " phone= ?, password= ?, email= ?, age= ? WHERE id= ?";

        try(
            Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.setInt(7, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM User WHERE id= ?";

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
    public  List<User> getAllUsers() {

        String query = "SELECT * FROM User";

        try(
            Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {
                users.add(getUserFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            myLogger().error(e);
        }
        return users;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setPhone(resultSet.getString("phone"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }

    public static void main(String[] args) {
        IUserDao userDaoImpl = new UserDaoImpl();
//        User user =  userDaoImpl.getEntityById(12);
//        System.out.println(user);
//        user.setFirstName("Anatoliy");
//        user.setLastName("Tapolskiy");
//        userDaoImpl.updateEntity(user);
//        userDaoImpl.setEntity(new User("Andrew", "Dallas", "+380931668949", "dallas192sm", "dash@gmail.com", 90));
//        userDaoImpl.removeEntityById(19);
        User userbuilder = new User.UserBuilder()
                               .firstName("Cate")
                               .lastName("Fedorenko")
                               .age(23)
                               .email("sdkofk@4jffp.com")
                               .password("jfjoiri3939494")
                               .phone("+380975457737")
                               .build();
        userDaoImpl.insertEntity(userbuilder);
        List<User> users = userDaoImpl.getAllUsers();
        System.out.println(users);

    }
}
