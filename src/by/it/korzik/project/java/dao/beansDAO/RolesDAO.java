package by.it.korzik.project.java.dao.beansDAO;

import by.it.korzik.project.java.dao.ConnectionCreator;
import by.it.korzik.project.java.dao.beans.Roles;
import by.it.korzik.project.java.dao.dao.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO extends AbstractDao implements DAOInterface<Roles> {
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
            String sql = String.format("INSERT INTO `korzik`.`Roles` (`id`, `role`)  VALUES (%d,'%s');",
                    role.getId(), role.getRole());
                    long id = executeUpdate(sql) ;
                    role.setId(id);
                    return id>0;
    }

    @Override
    public boolean update(Roles role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET `role`='%s' WHERE id = %d",
                role.getRole(), role.getId()
        );
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Roles role) throws SQLException {
        String sql = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        return executeUpdate(sql)>0;
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
