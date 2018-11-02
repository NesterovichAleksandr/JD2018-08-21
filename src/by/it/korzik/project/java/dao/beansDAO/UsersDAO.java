package by.it.korzik.project.java.dao.beansDAO;

import by.it.korzik.project.java.dao.ConnectionCreator;
import by.it.korzik.project.java.dao.beans.Users;
import by.it.korzik.project.java.dao.dao.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDao implements DAOInterface<Users> {

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
        String sql = String.format("INSERT INTO `Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`)  VALUES (%d,'%s','%s','%s','%s',%d);",
                user.getId(), user.getUserName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id());
        long id = executeUpdate(sql);
        user.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Users user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET `userName`='%s',`login`='%s',`password`='%s',`email`='%s',`roles_id`=%d WHERE users.ID = %d",
                user.getUserName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId()
        );
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Users user) throws SQLException {
        String sql = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public List<Users> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Users> getAll(String condition) throws SQLException {
        Users user = null;
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + condition + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
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
