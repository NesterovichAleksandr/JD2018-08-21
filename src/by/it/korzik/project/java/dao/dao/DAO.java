package by.it.korzik.project.java.dao.dao;


import by.it.korzik.project.java.dao.Reset;
import by.it.korzik.project.java.dao.beans.Menu;
import by.it.korzik.project.java.dao.beansDAO.OrdersDAO;
import by.it.korzik.project.java.dao.beansDAO.RolesDAO;
import by.it.korzik.project.java.dao.beansDAO.UsersDAO;

public class DAO {
    private static DAO instance;

    public UsersDAO user;
    public RolesDAO role;
    public DAOInterface<Menu> menu;
    public OrdersDAO order;

    private DAO() {
        role = new RolesDAO();
        user = new UsersDAO();
        menu = new UniversalDAO<>(new Menu(),"menu");
        order = new OrdersDAO();
    }

    public static DAO getDAO() {
        if (instance == null) {
            synchronized (DAO.class) {
                instance = new DAO();
            }
        }
        return instance;
    }

    public void reset() {
        Reset.init();
    }
}
