package by.it.kisielev.project2_0.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddAircraft {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    static void addData() {

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
            statement.executeUpdate("INSERT INTO `kisielev`.`aircrafts` (`id`, `aircraft`, `place`, `prace`, `users_id`) " +
                    "VALUES (DEFAULT, 'Ty-550', 550, 550, 2);");
            statement.executeUpdate("INSERT INTO `kisielev`.`aircrafts` (`id`, `aircraft`, `place`, `prace`, `users_id`) " +
                    "VALUES (DEFAULT, 'Ty-6000', 1000, 1500, 2);");
            statement.executeUpdate("INSERT INTO `kisielev`.`aircrafts` (`id`, `aircraft`, `place`, `prace`, `users_id`) " +
                    "VALUES (DEFAULT, 'Ty-12', 1050, 100, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
