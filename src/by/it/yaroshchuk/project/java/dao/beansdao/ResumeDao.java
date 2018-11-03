package by.it.yaroshchuk.project.java.dao.beansdao;

import by.it.yaroshchuk.project.java.beans.Resume;
import by.it.yaroshchuk.project.java.connection.ConnectionCreator;
import by.it.yaroshchuk.project.java.dao.InterfaceDao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResumeDao extends AbstractDao implements InterfaceDao<Resume> {
    @Override
    public Resume read(long id) throws SQLException {
        List<Resume> resumes = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (resumes.size() > 0) {
            return  resumes.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Resume resume) throws SQLException {
        String sql = String.format("INSERT INTO `resumes` (`resume_name`, `full_name`, `dob`, `country`, `city`, `education`," +
                        " `degree`, `graduate_year`, `experience`, `post`, `worktime`, `about`, `users_id`)" +
                        " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', %d, '%s', %d);",
                resume.getResumeName(),
                resume.getFullName(),
                resume.getDob(),
                resume.getCountry(),
                resume.getCity(),
                resume.getEducation(),
                resume.getDegree(),
                resume.getGraduateYear(),
                resume.getExperience(),
                resume.getPost(),
                resume.getWorktime(),
                resume.getAbout(),
                resume.getUsersId());
        long id = executeUpdate(sql);
        if (id > 0) resume.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Resume resume) throws SQLException {
        String sql = String.format("UPDATE `resumes` SET " +
                        "`resume_name` = '%s', " +
                        "`full_name` = '%s', " +
                        "`dob` = '%s', " +
                        "`country` = '%s', " +
                        "`city` = '%s', " +
                        "`education` = '%s', " +
                        "`degree` = '%s', " +
                        "`graduate_year` = %d, " +
                        "`experience` = '%s', " +
                        "`post` = '%s', " +
                        "`worktime`  = %d," +
                        "`about` = '%s', " +
                        "`users_id` = %d"+
                        " WHERE `id` = %d",
                resume.getResumeName(),
                resume.getFullName(),
                resume.getDob(),
                resume.getCountry(),
                resume.getCity(),
                resume.getEducation(),
                resume.getDegree(),
                resume.getGraduateYear(),
                resume.getExperience(),
                resume.getPost(),
                resume.getWorktime(),
                resume.getAbout(),
                resume.getUsersId(),
                resume.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Resume resume) throws SQLException {
        String sql = String.format("DELETE FROM `resumes` WHERE `resumes`.`id` = %d", resume.getId());
        return (0 < executeUpdate(sql));
    }

    public boolean delete(long usersId) throws SQLException {
        String sql = String.format("DELETE FROM `resumes` WHERE `resumes`.`users_id` = %d", usersId);
        return (0 < executeUpdate(sql));
    }

    @Override
    public List getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List getAll(String WHERE) throws SQLException {
        List<Resume> resumes = new ArrayList<>();
        String sql = "SELECT * FROM resumes " + WHERE + " ;";

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Resume resume = new Resume();
                resume.setId(resultSet.getLong("id"));
                resume.setResumeName(resultSet.getString("resume_name"));
                resume.setFullName(resultSet.getString("full_name"));
                resume.setDob(resultSet.getString("dob"));
                resume.setCountry(resultSet.getString("country"));
                resume.setCity(resultSet.getString("city"));
                resume.setEducation(resultSet.getString("education"));
                resume.setDegree(resultSet.getString("degree"));
                resume.setGraduateYear(resultSet.getInt("graduate_year"));
                resume.setExperience(resultSet.getString("experience"));
                resume.setPost(resultSet.getString("post"));
                resume.setWorktime(resultSet.getInt("worktime"));
                resume.setAbout(resultSet.getString("about"));
                resume.setUsersId(resultSet.getLong("users_id"));
                resumes.add((resume));
            }
        }
        return resumes;
    }
}
