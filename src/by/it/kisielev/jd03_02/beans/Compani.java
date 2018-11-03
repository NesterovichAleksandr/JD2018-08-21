package by.it.kisielev.jd03_02.beans;

public class Compani {

    private long id;
    private String compani;
    private String password;
    private long companis_id;

    public Compani(long id, String compani, String password, long companis_id) {

        this.id = id;
        this.compani = compani;
        this.password = password;
        this.companis_id = companis_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompani() { return compani; }

    public void setCompani(String compani){this.compani=compani;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){this.password= password; }

    public long getCompanis_id() {
        return companis_id;
    }

    public void setCompanis_id(long companis_id){this.companis_id= companis_id; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Aircraft='" + compani + '\'' +
                ", Password='" + password + '\'' +
                ", Compani_id=" + companis_id +
                '}';
    }
}
