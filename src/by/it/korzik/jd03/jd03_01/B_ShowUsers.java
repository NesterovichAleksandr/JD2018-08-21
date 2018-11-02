package by.it.korzik.jd03.jd03_01;

import java.sql.*;

public class B_ShowUsers {
    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
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
            statement.executeUpdate("USE `korzik`;");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `persons` WHERE 1");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name")+resultSet.getString("secondName")+" "+resultSet.getString("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
