package by.it.korolchuk.project.java.dao.simpledao;

import by.it.korolchuk.project.java.dao.InterfaceDAO;
import by.it.korolchuk.project.java.dao.UniversalDAO;
import by.it.korolchuk.project.java.dao.beans.Ad;
import by.it.korolchuk.project.java.dao.beans.Role;
import by.it.korolchuk.project.java.dao.beans.User;

public enum Dao {

    INSTANCE;

    public InterfaceDAO<Role> role = new UniversalDAO<>(new Role(), "roles");
    public InterfaceDAO<User> user = new UniversalDAO<>(new User(), "users");
    public InterfaceDAO<Ad> ad = new UniversalDAO<>(new Ad(), "ads");
}
