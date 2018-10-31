package by.it.korzik.jd03.jd03_03.beansDAO;

import by.it.korzik.jd03.jd03_03.ConnectionCreator;
import by.it.korzik.jd03.jd03_03.beans.Orders;
import by.it.korzik.jd03.jd03_03.dao.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO implements DAOInterface<Orders> {
    @Override
    public Orders read(long id) throws SQLException {
        List<Orders> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Orders order) throws SQLException {
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

    @Override
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

    @Override
    public boolean delete(Orders order) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        }
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Orders> getAll(String condition) throws SQLException {
        Orders order = null;
        List<Orders> Orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders " + condition + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                order = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getInt("Users_id"),
                        resultSet.getInt("menu_id"));
                Orders.add(order);
            }
            return Orders;
        }
    }
}

