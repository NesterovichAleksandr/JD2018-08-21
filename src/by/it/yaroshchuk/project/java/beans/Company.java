package by.it.yaroshchuk.project.java.beans;

public class Company {

    private long id;
    private String name;
    private String start_year;
    private String about;
    private long rolesId;

    public Company() {
    }

    public Company(long id, String name, String start_year, String about, long rolesId) {
        this.id = id;
        this.name = name;
        this.start_year = start_year;
        this.about = about;
        this.rolesId = rolesId;
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

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start_year='" + start_year + '\'' +
                ", about='" + about + '\'' +
                ", rolesId=" + rolesId +
                '}';
    }
}
