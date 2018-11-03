package by.it.yaroshchuk.project.java.beans;

import by.it.yaroshchuk.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailRequestDto {

    private long userId;
    private String userLogin;
    private String userEmail;
    private long resumeId;
    private String resumeName;
    private long companyId;
    private String companyName;
    private long companyUserId;


    private DetailRequestDto(long userId, String userLogin, String userEmail, long resumeId, String resumeName, long companyId, String companyName, long companyUserId) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.resumeId = resumeId;
        this.resumeName = resumeName;
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyUserId = companyUserId;
    }

    public static List<DetailRequestDto> getRequestDto() throws SQLException {
        List<DetailRequestDto> requests = new ArrayList<>();

        String sql = "SELECT `users`.`id`, `users`.`login`, `users`.`email`, `resumes`.`id`, " +
                "`resumes`.`resume_name`, `companies`.`id`, `companies`.`company_name`, " +
                "`companies`.`users_id` FROM `users` INNER JOIN `resumes` ON `users`.`id`=`resumes`.`users_id` " +
                "INNER JOIN `requests` ON `resumes`.`id`=`requests`.`resumes_id` INNER JOIN `companies` ON " +
                "`requests`.`companies_id`=`companies`.`id`";

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long userId = resultSet.getLong(1);
                String userLogin = resultSet.getString(2);
                String userEmail = resultSet.getString(3);
                long resumeId = resultSet.getLong(4);
                String resumeName = resultSet.getString(5);
                long companyId = resultSet.getLong(6);
                String companyName = resultSet.getString(7);
                long companyUserId = resultSet.getLong(8);
                DetailRequestDto requestDto = new DetailRequestDto(userId, userLogin, userEmail, resumeId, resumeName,
                        companyId, companyName, companyUserId);
                requests.add(requestDto);
            }
        }
        return requests;
    }



    @Override
    public String toString() {
        return "DetailRequestDto{" +
                "userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", resumeId=" + resumeId +
                ", resumeName='" + resumeName + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyUserId=" + companyUserId +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(long companyUserId) {
        this.companyUserId = companyUserId;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getRequestDto());
    }
}
