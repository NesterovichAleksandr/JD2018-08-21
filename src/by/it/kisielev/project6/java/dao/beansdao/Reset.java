package by.it.kisielev.project6.java.dao.beansdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: "+ e);
        }

        try(Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kisielev` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kisielev` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate(



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
