package by.it.kisielev.project6.java.beans;

public class Ad {
    private long id;
    private String aircraft;
    private int prace;
    private int place;
    private long comapani_id;

    public Ad(){
    }

    public Ad(long id, String aircraft, int prace, int place, long compani_id){
        this.id=id;
        this.aircraft=aircraft;
        this.prace=prace;
        this.place=place;
        this.comapani_id=compani_id;
    }

    public long getId(){return id;}

    public void setId(long id){this.id=id;}

    public String getAircraft(){return  aircraft;}

    public void setAircraft(String aircraft){this.aircraft=aircraft;}

    public int getPrace(){return prace;}

    public void setPlace(int place){this.prace=place;}

    public int getPlace(){return place;}

    public void setPrace(int prace){this.prace=prace;}

    public long getComapani_id(){return comapani_id;}

    public void setComapani_id(long comapani_id){this.comapani_id=comapani_id;}


    @Override
    public  String toString(){
        return "Ad(" +
                ", id=" + id +
                ", aircraft=" + aircraft + '\''+
                ", prace=" + prace + '\''+
                ", place=" + place + '\'' +
                ", compani_id=" + comapani_id+
                "}\n";
    }
}
