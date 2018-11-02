package by.it.korzik.jd03.jd03_03.beansDAO;

import by.it.korzik.jd03.jd03_03.ConnectionCreator;
import by.it.korzik.jd03.jd03_03.beans.Users;
import by.it.korzik.jd03.jd03_03.dao.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements DAOInterface<Users> {

    @Override
    public Users read(long id) throws SQLException {
        List<Users> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Users user) throws SQLException {
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

    @Override
    public boolean update(Users user) throws SQLException {
        String update = String.format(
                "UPDATE `users` SET `userName`='%s',`login`='%s',`password`='%s',`email`='%s',`roles_id`=%d WHERE users.ID = %d",
                user.getUserName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return statement.executeUpdate(update) == 1;
        }
    }

    @Override
    public boolean delete(Users user) throws SQLException {
        String sql = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(sql) == 1);
        }
    }

    @Override
    public List<Users> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Users> getAll(String condition) throws SQLException {
        Users user=null;
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + condition + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("roles_id"));
                users.add(user);
            }
            return users;
        }
    }
}
