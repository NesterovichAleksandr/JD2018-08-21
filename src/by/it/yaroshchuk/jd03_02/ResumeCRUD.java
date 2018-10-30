package by.it.yaroshchuk.jd03_02;

import by.it.yaroshchuk.jd03_02.beans.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResumeCRUD {

    static boolean create(Resume resume) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `resumes` (`full_name`, `dob`, `country`, `city`, `education`," +
                            " `degree`, `graduate_year`, `experience`, `post`, `worktime`, `users_id`)" +
                            " VALUES ('%s', '%tc', '%s', '%s', '%s', '%s', %d, '%s', '%s', %d, %d);",
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
                    resume.getUsersId());
            System.out.println(sql);
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    resume.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Resume read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `resumes` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Resume(resultSet.getLong("id"),
                        resultSet.getString("full_name"),
                        resultSet.getTimestamp("dob"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("education"),
                        resultSet.getString("degree"),
                        resultSet.getInt("graduate_year"),
                        resultSet.getString("experience"),
                        resultSet.getString("post"),
                        resultSet.getInt("worktime"),
                        resultSet.getLong("users_id"));
            }
        }
        return null;
    }

    static boolean update(Resume resume) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `resumes` SET " +
                            "`full_name` = '%s', " +
                            "`dob` = '%tc', " +
                            "`country` = '%s', " +
                            "`city` = '%s', " +
                            "`education` = '%s'," +
                            " `degree` = '%s', " +
                            "`graduate_year` = %d, " +
                            "`experience` = '%s', " +
                            "`post` = '%s', " +
                            "`worktime`  = %d," +
                            "`users_id` = %d"+
                            " WHERE `id` = %d",
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
                    resume.getUsersId(),
                    resume.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    static boolean delete(Resume resume) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `resumes` WHERE `id`=%d",
                    resume.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}
