package by.it.korzik.jd03.jd03_02;

import by.it.korzik.jd03.jd03_02.beans.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersCRUD {
    boolean create(Orders order) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `orders`(`id`, `Users_id`, `menu_id`) VALUES (%d,%d,%d);",
                    order.getId(), order.getUsers_id(),order.getMenu_id());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    order.setId(id);
                    return true;
                }
            }
        }
     return false;
    }

    public Orders read(long id) throws SQLException {
        Orders orderResult = null;
        String readUserSQL = "SELECT * FROM orders where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                orderResult = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getInt("Users_id"),
                        resultSet.getInt("menu_id"));
            }
        }
        return orderResult;
    }

    public boolean update(Orders order) throws SQLException {
        String update = String.format(
                "UPDATE `orders` SET `Users_id`=%d,`menu_id`=%d WHERE id = %d",
                order.getUsers_id(),order.getMenu_id(), order.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return  (statement.executeUpdate(update) == 1);
        }
    }
    public boolean delete(Orders order) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        }
    }

    public static void main(String[] args) {
        try {
            OrdersCRUD ordersCRUD = new OrdersCRUD();
            Orders order = new Orders(0, 1,1);
            ordersCRUD.create(order);
            System.out.println("create " + order);
            order.setMenu_id(2);
            ordersCRUD.update(order);
            System.out.println("update "+ order);
            System.out.println("read "+ ordersCRUD.read(3));
            System.out.println("read "+ ordersCRUD.read(order.getId()));
            System.out.println("DELETE:"+ordersCRUD.delete(order));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
