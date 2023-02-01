package com.solvd.internetshop.dao.jdbcmysqlimpl;



import com.solvd.internetshop.dao.IUserRoleDao;
import com.solvd.internetshop.model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;

public class UserRoleDaoImpl implements IUserRoleDao {

    private UserRole userRole = new UserRole();
    private  List<UserRole> userRoles = new ArrayList<>();




    @Override
    public UserRole getEntityById(int id) {

        String query = "SELECT * FROM UserRole WHERE id = ?";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                String role = resultSet.getString("role");
                userRole =  new UserRole (id, role);
            }

            resultSet.close();
            return userRole;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertEntity(UserRole userRole) {

        String insertQuery =
                "INSERT INTO UserRole (role) VALUE (?)";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)) {

            preparedStatement.setString(1, userRole.getRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEntity(UserRole userRole) {

        String query = "UPDATE UserRole SET role= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userRole.getRole());
            preparedStatement.setInt(2, userRole.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM UserRole WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<UserRole> getAllUserRoles() {

        String query = "SELECT * FROM UserRole";

        try(Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                userRoles.add(new UserRole(resultSet.getInt("id"),
                        resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    public static void main(String[] args) {
        IUserRoleDao userRoleDaoImpl = new UserRoleDaoImpl();
        UserRole userRole = userRoleDaoImpl.getEntityById(3);

//        userRole.setRole("Customer");
//        userRoleDaoImpl.updateEntity(userRole);
//        userRoleDaoImpl.setEntity(new UserRole("SomeBody"));
//        userRoleDaoImpl.removeEntityById(10);


        List<UserRole> userRoles = userRoleDaoImpl.getAllUserRoles();
        System.out.println(userRoles);

    }

}
