package by.it.yaroshchuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddData {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (
                Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `hr`.`resumes` " +
                    "(`id`, `full_name`, `dob`, `country`, `city`, `education`, `degree`, " +
                    "`graduate_year`, `experience`, `post`, `worktime`, `users_id`) " +
                    "VALUES (NULL, 'Full Name1', '1992-10-25 00:00:00.000000', 'Country1', " +
                    "'City1', 'University name1', 'some degree', '2015', 'Company name1', " +
                    "'some post', '2', '2');");
        }
    }
}
