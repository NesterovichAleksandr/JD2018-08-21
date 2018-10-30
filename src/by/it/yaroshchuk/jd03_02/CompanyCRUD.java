package by.it.yaroshchuk.jd03_02;

import by.it.yaroshchuk.jd03_02.beans.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyCRUD {

    static boolean create(Company company) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `companies` (`company_name`, `start_year`, `about`, `roles_id`)" +
                            " VALUES ('%s', '%s', '%s', %d);",
                    company.getName(),
                    company.getStart_year(),
                    company.getAbout(),
                    company.getRolesId());
            System.out.println(sql);
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    company.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Company read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `companies` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Company(resultSet.getLong("id"),
                        resultSet.getString("company_name"),
                        resultSet.getString("start_year"),
                        resultSet.getString("about"),
                        resultSet.getLong("roles_id"));
            }
        }
        return null;
    }

    static boolean update(Company company) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `companies` SET " +
                            "`company_name`='%s'" +
                            "`start_year`='%s'" +
                            "`about`='%s'" +
                            "`roles_id`=%d WHERE `id`=%d",
                    company.getName(),
                    company.getStart_year(),
                    company.getAbout(),
                    company.getRolesId(),
                    company.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    static boolean delete(Company company) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `companies` WHERE `id`=%d",
                    company.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}
