package by.it.kisielev.jd03_03.simpledao;

import by.it.kisielev.jd03_03.InterfaceDao;
import by.it.kisielev.jd03_03.UniversalDAO;
import by.it.kisielev.jd03_03.beans.Ad;
import by.it.kisielev.jd03_03.beans.Role;
import by.it.kisielev.jd03_03.beans.Compani;

public enum  Dao {
    INSTANCE;

    public InterfaceDao<Role> role = new UniversalDAO<>(new Role(), "roles");
    public InterfaceDao<Compani> user = new UniversalDAO<>(new Compani(), "users");
    public InterfaceDao<Ad> ad = new UniversalDAO<>(new Ad(), "ads");
}
