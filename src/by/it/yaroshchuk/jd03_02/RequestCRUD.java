package by.it.yaroshchuk.jd03_02;

import by.it.yaroshchuk.jd03_02.beans.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestCRUD {

    static boolean create(Request request) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `requests` (`message`,`companies_id`,`users_id`)" +
                            " VALUES ('%s', %d, %d);",
                    request.getMessage(),
                    request.getCompaniesId(),
                    request.getUsersId());
            System.out.println(sql);
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    request.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Request read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `requests` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Request(resultSet.getLong("id"),
                        resultSet.getString("message"),
                        resultSet.getLong("companies_id"),
                        resultSet.getLong("users_id"));
            }
        }
        return null;
    }

    static boolean update(Request request) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `requests` SET " +
                    "`message`='%s', " +
                    "`companies_id`=%d, " +
                    "`users_id`=%d WHERE `id`=%d",
                    request.getMessage(),
                    request.getCompaniesId(),
                    request.getUsersId(),
                    request.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    static boolean delete(Request request) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `requests` WHERE `id`=%d",
                    request.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}
