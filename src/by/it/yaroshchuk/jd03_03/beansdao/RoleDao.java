package by.it.yaroshchuk.jd03_03.beansdao;

import by.it.yaroshchuk.jd03_03.beans.Role;
import by.it.yaroshchuk.jd03_03.simpledao.ConnectionCreator;
import by.it.yaroshchuk.jd03_03.simpledao.InterfaceDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {
    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return  roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO roles (role) values('%s');", role.getRole());
        long id = executeUpdate(sql);
        if (id > 0) role.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE `roles` SET `role` = '%s' WHERE `roles`.`id` = %d",
                role.getRole(), role.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM `roles` WHERE `roles`.`id` = %d", role.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List getAll(String WHERE) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + " ;";

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                roles.add((role));
            }
        }
        return roles;
    }
}
