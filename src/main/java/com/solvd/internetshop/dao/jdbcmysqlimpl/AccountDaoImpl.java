package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IAccountDao;
import com.solvd.internetshop.dao.IUserRoleDao;
import com.solvd.internetshop.model.Account;
import com.solvd.internetshop.model.UserRole;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            resultSet.close();
            return account;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setEntity(Account account) {

    }

    @Override
    public void updateEntity(Account account) {

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
        Account account = iAccountDao.getEntityById(3);
        System.out.println(account);
//        userRole.setRole("Customer");
//        userRoleDaoImpl.updateEntity(userRole);
//        userRoleDaoImpl.setEntity(new UserRole("SomeBody"));
//        userRoleDaoImpl.removeEntityById(10);


//        List<Account> accounts = iAccountDao.getAllAccounts();
//        System.out.println(accounts);

    }


}
