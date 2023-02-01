package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IAccountDao;
import com.solvd.internetshop.dao.IUserRoleDao;
import com.solvd.internetshop.model.Account;
import com.solvd.internetshop.model.UserRole;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;

public class AccountDaoImpl implements IAccountDao {

    private Account account = new Account();
    private List<Account> accounts = new ArrayList<>();



    @Override
    public Account getEntityById(int id) {

        String query = "SELECT * FROM Account WHERE id = ?";

        try (Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                int idUser = resultSet.getInt("idUser");
                int idUserRole = resultSet.getInt("idUserRole");

                account =  new Account(id, idUser, idUserRole);
            }
            /*
            Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(insertOrderQuery,
                        Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, order.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            order.setId(resultSet.getLong(1));
            statement.close();
            insertOrdersProducts(order, connection);
             */

            resultSet.close();
            return account;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertEntity(Account account) {

    }

    @Override
    public void updateEntity(Account account) {
        String query = "UPDATE Account SET idUser= ? WHERE id= ?";

        try(Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, account.getIdUser());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeEntityById(int id) {

    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    public static void main(String[] args) {
        IAccountDao iAccountDao = new AccountDaoImpl();
        Account account = iAccountDao.getEntityById(5);
        System.out.println(account);
        account.setIdUser(0);
        iAccountDao.updateEntity(account);
        System.out.println(account);
//        userRole.setRole("Customer");
//        userRoleDaoImpl.updateEntity(userRole);
//        userRoleDaoImpl.setEntity(new UserRole("SomeBody"));
//        userRoleDaoImpl.removeEntityById(10);


//        List<Account> accounts = iAccountDao.getAllAccounts();
//        System.out.println(accounts);

    }


}
