package by.it.yaroshchuk.jd03_02.beans;

import java.sql.Timestamp;

public class Resume {

    private long id;
    private String fullName;
    private Timestamp dob;
    private String country;
    private String city;
    private String education;
    private String degree;
    private int graduateYear;
    private String experience;
    private String post;
    private int worktime;
    private long usersId;

    public Resume() {
    }

    public Resume(long id, String fullName, Timestamp dob, String country, String city, String education,
                  String degree, int graduateYear, String experience, String post, int worktime, long usersId) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.country = country;
        this.city = city;
        this.education = education;
        this.degree = degree;
        this.graduateYear = graduateYear;
        this.experience = experience;
        this.post = post;
        this.worktime = worktime;
        this.usersId = usersId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", education='" + education + '\'' +
                ", degree='" + degree + '\'' +
                ", graduateYear=" + graduateYear +
                ", experience='" + experience + '\'' +
                ", post='" + post + '\'' +
                ", worktime=" + worktime +
                ", usersId=" + usersId +
                '}';
    }
}
