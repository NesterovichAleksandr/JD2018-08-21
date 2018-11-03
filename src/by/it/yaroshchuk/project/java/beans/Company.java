package by.it.yaroshchuk.project.java.beans;

public class Company {

    private long id;
    private String name;
    private String startYear;
    private String about;
    private long usersId;

    public Company() {
    }

    public Company(long id, String name, String startYear, String about, long usersId) {
        this.id = id;
        this.name = name;
        this.startYear = startYear;
        this.about = about;
        this.usersId = usersId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startYear='" + startYear + '\'' +
                ", about='" + about + '\'' +
                ", usersId=" + usersId +
                '}';
    }
}
