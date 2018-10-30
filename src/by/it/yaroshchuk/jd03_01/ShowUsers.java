package by.it.yaroshchuk.jd03_01;

import java.sql.*;

public class ShowUsers {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/hr" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT hr.roles.role, hr.users.login, hr.users.email FROM `users`,`roles` WHERE hr.users.roles_id = hr.roles.id ;");
            while (resultSet.next()) {
                System.out.println("Role: " + resultSet.getString("role")
                        + " Login: " + resultSet.getString("login")
                        + " Email: " + resultSet.getString("email"));
            }
        }
    }
}
