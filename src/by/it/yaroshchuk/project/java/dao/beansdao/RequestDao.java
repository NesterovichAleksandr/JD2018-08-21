package by.it.yaroshchuk.project.java.dao.beansdao;


import by.it.yaroshchuk.project.java.beans.Request;
import by.it.yaroshchuk.project.java.connection.ConnectionCreator;
import by.it.yaroshchuk.project.java.dao.InterfaceDao;


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
        String sql = String.format("INSERT INTO `requests` (`message`,`companies_id`,`resumes_id`)" +
                        " VALUES ('%s', %d, %d);",
                request.getMessage(),
                request.getCompaniesId(),
                request.getResumesId());
        long id = executeUpdate(sql);
        if (id > 0) request.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Request request) throws SQLException {
        String sql = String.format("UPDATE `requests` SET " +
                "`message`='%s', " +
                "`companies_id`=%d, " +
                "`resumes_id`=%d WHERE `id`=%d",
                request.getMessage(),
                request.getCompaniesId(),
                request.getResumesId(),
                request.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Request request) throws SQLException {
        String sql = String.format("DELETE FROM `requests` WHERE `requests`.`id` = %d", request.getId());
        return (0 < executeUpdate(sql));
    }

    public boolean deleteFromResume(long resumeId) throws SQLException {
        String sql = String.format("DELETE FROM `requests` WHERE `requests`.`resumes_id` = %d", resumeId);
        return (0 < executeUpdate(sql));
    }

    public boolean deleteFromCompany(long companyId) throws SQLException {
        String sql = String.format("DELETE FROM `requests` WHERE `requests`.`companies_id` = %d", companyId);
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
                request.setResumesId(resultSet.getLong("resumes_id"));
                requests.add((request));
            }
        }
        return requests;
    }
}
