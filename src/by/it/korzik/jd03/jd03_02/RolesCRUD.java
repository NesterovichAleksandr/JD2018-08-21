package by.it.korzik.jd03.jd03_02;

import by.it.korzik.jd03.jd03_02.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RolesCRUD {
    boolean create(Roles role) throws SQLException {

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

    public Roles read(long id) throws SQLException {
        Roles roleResult = null;
        String readUserSQL = "SELECT * FROM roles where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                roleResult = new Roles(
                        resultSet.getInt("id"),
                        resultSet.getString("role"));
            }
        }
        return roleResult;
    }

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
    public boolean delete(Roles role) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        }
    }

    public static void main(String[] args) {
        try {
            RolesCRUD rolesCRUD = new RolesCRUD();
            Roles role = new Roles(0, "Nick");
            rolesCRUD.create(role);
            System.out.println("create " + role);
            role.setRole("aaaaaaaaa");
            rolesCRUD.update(role);
            System.out.println("update "+ role);
            System.out.println("read "+ rolesCRUD.read(3));
            System.out.println("read "+ rolesCRUD.read(role.getId()));
            System.out.println("DELETE:"+rolesCRUD.delete(role));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
