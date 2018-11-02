package by.it.korzik.jd03.jd03_02;

import by.it.korzik.jd03.jd03_02.beans.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersCRUD {
    boolean create(Users user) {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`)  VALUES (%d,'%s','%s','%s','%s',%d);",
                    user.getId(), user.getUserName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setId(id);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Users read(long id) throws SQLException {
        Users userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("roles_id"));
            }
        }
        return userResult;
    }

    public boolean update(Users user) throws SQLException {
        String update = String.format(
                "UPDATE `users` SET `userName`='%s',`login`='%s',`password`='%s',`email`='%s',`roles_id`=%d WHERE users.ID = %d",
                user.getUserName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return statement.executeUpdate(update)==1;
        }

    }
    public boolean delete(Users user) throws SQLException {
        String sql = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) {
        try {
            UsersCRUD usersCRUD = new UsersCRUD();
            Users user = new Users(0, "Nick", "Name", "NickName", "NickName@gmail.com", 1);
            usersCRUD.create(user);
            System.out.println("create " + user);
            user.setEmail("aaaaaaaaa@gmail.com");
            usersCRUD.update(user);
            System.out.println("update "+ user);
            System.out.println("read "+ usersCRUD.read(3));
            System.out.println("read "+ usersCRUD.read(user.getId()));
            System.out.println("DELETE:"+usersCRUD.delete(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
