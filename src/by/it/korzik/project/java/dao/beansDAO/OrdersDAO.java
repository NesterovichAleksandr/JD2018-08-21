package by.it.korzik.project.java.dao.beansDAO;

import by.it.korzik.project.java.dao.ConnectionCreator;
import by.it.korzik.project.java.dao.beans.Orders;
import by.it.korzik.project.java.dao.dao.DAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends AbstractDao implements DAOInterface<Orders> {
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
            String sql = String.format("INSERT INTO `orders`(`id`, `Users_id`, `menu_id`) VALUES (%d,%d,%d);",
                    order.getId(), order.getUsers_id(),order.getMenu_id());
                    long id = executeUpdate(sql);
                    order.setId(id);
                    return id>0;
    }

    @Override
    public boolean update(Orders order) throws SQLException {
        String update = String.format(
                "UPDATE `orders` SET `Users_id`=%d,`menu_id`=%d WHERE id = %d",
                order.getUsers_id(),order.getMenu_id(), order.getId()
        );
        return executeUpdate(update)>0;
    }

    @Override
    public boolean delete(Orders order) throws SQLException {
        String sql = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        return executeUpdate(sql)>0;
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

