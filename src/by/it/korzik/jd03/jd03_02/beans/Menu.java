package by.it.korzik.jd03.jd03_02.beans;

import java.util.Objects;

public class Menu {
    private long id;
    private String name;
    private String ingridients;
    private double weight;
    private double price;

    public Menu() {
    }

    public Menu(long id, String name, String ingridients, double weight, double price) {

        this.id = id;
        this.name = name;
        this.ingridients = ingridients;
        this.weight = weight;
        this.price = price;
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

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                Double.compare(menu.weight, weight) == 0 &&
                Double.compare(menu.price, price) == 0 &&
                Objects.equals(name, menu.name) &&
                Objects.equals(ingridients, menu.ingridients);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, ingridients, weight, price);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingridients='" + ingridients + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
