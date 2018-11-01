package by.it.yaroshchuk.jd03_03.beansdao;

import by.it.yaroshchuk.jd03_03.beans.Request;
import by.it.yaroshchuk.jd03_03.simpledao.ConnectionCreator;
import by.it.yaroshchuk.jd03_03.simpledao.InterfaceDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDao extends AbstractDao implements InterfaceDao<Request> {
    @Override
    public Request read(long id) throws SQLException {
        List<Request> requests = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (requests.size() > 0) {
            return  requests.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Request request) throws SQLException {
        String sql = String.format("INSERT INTO `requests` (`message`,`companies_id`,`users_id`)" +
                        " VALUES ('%s', %d, %d);",
                request.getMessage(),
                request.getCompaniesId(),
                request.getUsersId());
        long id = executeUpdate(sql);
        if (id > 0) request.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Request request) throws SQLException {
        String sql = String.format("UPDATE `requests` SET " +
                "`message`='%s', " +
                "`companies_id`=%d, " +
                "`users_id`=%d WHERE `id`=%d",
                request.getMessage(),
                request.getCompaniesId(),
                request.getUsersId(),
                request.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Request request) throws SQLException {
        String sql = String.format("DELETE FROM `requests` WHERE `requests`.`id` = %d", request.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List getAll(String WHERE) throws SQLException {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests " + WHERE + " ;";

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Request request = new Request();
                request.setId(resultSet.getLong("id"));
                request.setMessage(resultSet.getString("message"));
                request.setCompaniesId(resultSet.getLong("companies_id"));
                request.setUsersId(resultSet.getLong("users_id"));
                requests.add((request));
            }
        }
        return requests;
    }
}
