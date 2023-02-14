package com.solvd.internetshop.dao.jdbcmysqlimpl;

import com.solvd.internetshop.dao.IAccountDao;
import com.solvd.internetshop.model.Account;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.internetshop.connection.DbConnection.getApacheDbConnection;
import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class AccountDaoImpl implements IAccountDao {

    private Account account = new Account();
    private List<Account> accounts = new ArrayList<>();



    @Override
    public Account getEntityById(int id) {

        String query = "SELECT * FROM Account WHERE id = ?";

        try (
             Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                account =  getAccountFromResultSet(resultSet);
            }

            resultSet.close();
            return account;

        } catch (SQLException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertEntity(Account account) {
        String insertQuery =
                "INSERT INTO Account (idUser, idUserRole) VALUES (?, ?)";

        try (
             Connection connection = getApacheDbConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(insertQuery)
        ) {

            preparedStatement.setInt(1, account.getIdUser());
            preparedStatement.setInt(2, account.getIdUserRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(Account account) {

        String query = "UPDATE Account SET idUser= ? WHERE id= ?";

        try (
            Connection connection = getApacheDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, account.getIdUser());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            myLogger().error(e);
        }

    }

    @Override
    public void removeEntityById(int id) {

        String query = "DELETE FROM Account WHERE id= ?";

        try (
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
    public List<Account> getAllAccounts() {

        String query = "SELECT * FROM Account";

        try (
            Connection connection = getApacheDbConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {

                accounts.add(getAccountFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            myLogger().error(e);
        }
        return accounts;
    }

    private Account getAccountFromResultSet(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setIdUser(resultSet.getInt("idUser"));
        account.setIdUserRole(resultSet.getInt("idUserRole"));
        return account;
    }

    public static void main(String[] args) {
        IAccountDao iAccountDao = new AccountDaoImpl();
        Account account = iAccountDao.getEntityById(5);
        System.out.println(account);

//        List<Account> accounts = iAccountDao.getAllAccounts();
//        System.out.println(accounts);

    }


}
