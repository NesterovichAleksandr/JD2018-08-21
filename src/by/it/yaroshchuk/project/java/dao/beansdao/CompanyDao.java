package by.it.yaroshchuk.project.java.dao.beansdao;

import by.it.yaroshchuk.project.java.beans.Company;
import by.it.yaroshchuk.project.java.connection.ConnectionCreator;
import by.it.yaroshchuk.project.java.dao.InterfaceDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends AbstractDao implements InterfaceDao<Company> {
    @Override
    public Company read(long id) throws SQLException {
        List<Company> companies = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (companies.size() > 0) {
            return  companies.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Company company) throws SQLException {
        String sql = String.format("INSERT INTO `companies` (`company_name`, `start_year`, `about`, `roles_id`)" +
                        " VALUES ('%s', '%s', '%s', %d);",
                company.getName(),
                company.getStart_year(),
                company.getAbout(),
                company.getRolesId());
        long id = executeUpdate(sql);
        if (id > 0) company.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Company company) throws SQLException {
        String sql = String.format("UPDATE `companies` SET " +
                        "`company_name`='%s'," +
                        "`start_year`='%s'," +
                        "`about`='%s'," +
                        "`roles_id`=%d WHERE `id`=%d",
                company.getName(),
                company.getStart_year(),
                company.getAbout(),
                company.getRolesId(),
                company.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Company company) throws SQLException {
        String sql = String.format("DELETE FROM `companies` WHERE `companies`.`id` = %d", company.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List getAll(String WHERE) throws SQLException {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM companies " + WHERE + " ;";

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getLong("id"));
                company.setName (resultSet.getString("company_name"));
                company.setStart_year(resultSet.getString("start_year"));
                company.setAbout(resultSet.getString("about"));
                company.setRolesId(resultSet.getLong("roles_id"));
                companies.add((company));
            }
        }
        return companies;
    }
}
