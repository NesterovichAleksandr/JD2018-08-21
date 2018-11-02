package by.it.korzik.jd03.jd03_02.beans;

import java.util.Objects;

public class Orders {
    private long id;
    private long Users_id;
    private long menu_id;

    public Orders() {
    }

    public Orders(long id, long users_id, long menu_id) {
        this.id = id;
        Users_id = users_id;
        this.menu_id = menu_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsers_id() {
        return Users_id;
    }

    public void setUsers_id(long users_id) {
        Users_id = users_id;
    }

    public long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(long menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                Users_id == orders.Users_id &&
                menu_id == orders.menu_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, Users_id, menu_id);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", Users_id=" + Users_id +
                ", menu_id=" + menu_id +
                '}';
    }
}
