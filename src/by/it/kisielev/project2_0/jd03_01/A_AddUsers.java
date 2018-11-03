package by.it.kisielev.project2_0.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUsers {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    static void addUser() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT INTO `kisielev`.`users` (`id`, `login`, `password`, `companis_id`) " +
                    "VALUES (DEFAULT, 'Admin', 'Admonpass', 1);\n");
            statement.executeUpdate("INSERT INTO `kisielev`.`users` (`id`, `login`, `password`, `companis_id`)" +
                    "VALUES (DEFAULT, 'User', 'Userpass', 2);\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}