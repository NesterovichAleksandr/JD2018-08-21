package by.it.kisielev.jd03_02;

import by.it.kisielev.jd03_02.beans.Compani;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompaniCRUD {

    static boolean create(Compani compani) throws SQLException{
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `companis`(`compani`, `password`, `role_id`)" +
                            " VALUES ('%s','%s',%d);",
                    compani.getCompani(),
                    compani.getPassword(),
                    compani.getCompanis_id());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    compani.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static  Compani read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `companis` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Compani(
                        resultSet.getLong("id"),
                        resultSet.getString("aircraft"),
                        resultSet.getString("password"),
                        resultSet.getLong("role_id")
                );
            }
            return null;
        }
    }

    static boolean update(Compani compani) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `companis` SET " +
                            "`compani`='%s'," +
                            "`password`='%s'," +
                            "`role_id`=%d WHERE `id`=%d",
                    compani.getCompani(),
                    compani.getPassword(),
                    compani.getCompanis_id());
            return (statement.executeUpdate(sql) == 1);
        }

    }

    static boolean delete(Compani compani) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `companis` WHERE `id`=%d",
                    compani.getId());
            return (statement.executeUpdate(sql) == 1);
        }

    }

    public static void main(String[] args) throws SQLException {
        Compani compani = new Compani(0, "airlains","qwerty", 2);
        if (create(compani))
            System.out.println("Create OK: " + compani);
        long id = compani.getId();
        compani = read(id);
        if (compani!=null)
            System.out.println("Read OK: "+compani);
        compani.setCompani("airlains1954");
        if (update(compani))
            System.out.println("Update OK: " + compani);
        if (delete(compani))
            System.out.println("Delete OK: " + compani);
    }

}
