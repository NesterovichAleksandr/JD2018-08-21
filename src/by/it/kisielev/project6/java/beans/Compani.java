package by.it.kisielev.project6.java.beans;

public class Compani {

    private long id;
    private String aircraft;
    private String password;
    private int prace;
    private int place;
    private long companis_id;


    public Compani() {
    }

    public Compani(long id, String aircraft, int prace, String password, int place, long companis_id) {

        this.id = id;
        this.aircraft = aircraft;
        this.prace = prace;
        this.password = password;
        this.place = place;
        this.companis_id = companis_id;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String Aircraft) {this.aircraft=aircraft;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){this.password=password;}

    public int getPrace() {
        return prace;
    }

    public void setPrace(int prace){this.place=prace;}

    public void setPlace(int place) { this.place=place; }

    public long getCompanis_id() {
        return companis_id;
    }

    public void setCompanis_id(int companis_id) { this.companis_id=companis_id;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Aircraft='" + aircraft + '\'' +
                ", Password='" + password + '\'' +
                ", Prace='" + prace + '\'' +
                ", Place='" + place + '\'' +
                ", Compani_id=" + companis_id +
                '}';
    }
}
