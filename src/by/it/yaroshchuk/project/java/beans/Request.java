package by.it.yaroshchuk.project.java.beans;

public class Request {

    private long id;
    private String message;
    private long companiesId;
    private long usersId;

    public Request() {
    }

    public Request(long id, String message, long companiesId, long usersId) {
        this.id = id;
        this.message = message;
        this.companiesId = companiesId;
        this.usersId = usersId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCompaniesId() {
        return companiesId;
    }

    public void setCompaniesId(long companiesId) {
        this.companiesId = companiesId;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", companiesId=" + companiesId +
                ", usersId=" + usersId +
                '}';
    }
}
