package by.it.yaroshchuk.project.java.beans;

public class Request {

    private long id;
    private String message;
    private long companiesId;
    private long resumesId;

    public Request() {
    }

    public Request(long id, String message, long companiesId, long resumesId) {
        this.id = id;
        this.message = message;
        this.companiesId = companiesId;
        this.resumesId = resumesId;
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

    public long getResumesId() {
        return resumesId;
    }

    public void setResumesId(long resumesId) {
        this.resumesId = resumesId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", companiesId=" + companiesId +
                ", resumesId=" + resumesId +
                '}';
    }
}
