package by.it.korzik.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
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


        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 1, 1);");
            statement.executeUpdate("INSERT INTO `orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 2, 1);");
            statement.executeUpdate("INSERT INTO `orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 1, 2);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
