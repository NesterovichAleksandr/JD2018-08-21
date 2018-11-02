package by.it.voinilo.project.java.beans;

public class Ads {
    private long id;
    private String description;
    private String address;
    private String name;
    private String price;
    private String condition;
    private String number;
    private long roleparam_id;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getRoleparam_id() {
        return roleparam_id;
    }

    public void setRoleparam_id(long roleparam_id) {
        this.roleparam_id = roleparam_id;
    }

    public Ads(long id,
               String description,
               String address,
               String name,
               String price,
               String condition,
               String number,
               long roleparam_id) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.name = name;
        this.price = price;
        this.condition = condition;
        this.number = number;
        this.roleparam_id = roleparam_id;
    }

    public Ads() {
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", condition='" + condition + '\'' +
                ", number='" + number + '\'' +
                ", roleparam_id=" + roleparam_id +
                '}';
    }
}
