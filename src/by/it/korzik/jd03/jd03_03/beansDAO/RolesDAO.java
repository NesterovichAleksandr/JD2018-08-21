package by.it.korzik.jd03.jd03_03.beansDAO;

import by.it.korzik.jd03.jd03_03.ConnectionCreator;
import by.it.korzik.jd03.jd03_03.beans.Roles;
import by.it.korzik.jd03.jd03_03.dao.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO implements DAOInterface<Roles> {
    @Override
    public Roles read(long id) throws SQLException {
        List<Roles> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Roles role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `korzik`.`Roles` (`id`, `role`)  VALUES (%d,'%s');",
                    role.getId(), role.getRole());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    role.setId(id);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(Roles role) throws SQLException {
        String update = String.format(
                "UPDATE `roles` SET `role`='%s' WHERE id = %d",
                role.getRole(), role.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return  (statement.executeUpdate(update) == 1);
        }
    }

    @Override
    public boolean delete(Roles role) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        }
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Roles> getAll(String condition) throws SQLException {
        Roles role = null;
        List<Roles> Roles = new ArrayList<>();
        String sql = "SELECT * FROM Roles " + condition + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                role = new Roles(
                        resultSet.getInt("id"),
                        resultSet.getString("role"));
                Roles.add(role);
            }
            return Roles;
        }
    }
}
