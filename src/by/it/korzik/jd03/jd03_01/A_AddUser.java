package by.it.korzik.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/korzik" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static String USER_DB = "root";
    private static String PASSWORD_DB = "";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }


        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'taskA', 'admin', 'iamTaskA', 'taskA@gmail.com', 1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}