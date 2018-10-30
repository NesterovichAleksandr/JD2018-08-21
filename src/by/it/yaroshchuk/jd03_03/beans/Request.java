package by.it.yaroshchuk.jd03_03.beans;

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
}
