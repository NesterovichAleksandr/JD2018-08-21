package by.it.yaroshchuk.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("Users with their roles: ");
            String sql = String.format(
                    "SELECT `roles`.`role`, `users`.`login` FROM `users` LEFT JOIN `roles` ON `users`.`roles_id`=`roles`.`id`");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(" -Role: " + resultSet.getString("role")
                        + " Login: " + resultSet.getString("login"));
            }

            sql = String.format("SELECT COUNT(*) FROM `users`");
            resultSet = statement.executeQuery(sql);
            if (resultSet.next())
                System.out.println("\nUSERS COUNT: " + resultSet.getInt(1));
            sql = String.format("SELECT COUNT(*) FROM `roles`");
            resultSet = statement.executeQuery(sql);
            if (resultSet.next())
                System.out.println("ROLES COUNT: " + resultSet.getInt(1));
        }
    }
}
