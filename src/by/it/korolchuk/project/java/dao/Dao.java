package by.it.korolchuk.project.java.dao;


import by.it.korolchuk.project.java.dao.entityDAO.AdDao;
import by.it.korolchuk.project.java.dao.entityDAO.Reset;
import by.it.korolchuk.project.java.dao.entityDAO.RoleDao;
import by.it.korolchuk.project.java.dao.entityDAO.UserDao;


public class Dao {

    private static Dao instance;

    public UserDao user;
    public RoleDao role;
    public AdDao ad;


    private Dao() {
    }

    public static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {

                if (instance == null) {
                    instance = new Dao();
                    instance.user = new UserDao();
                    instance.role = new RoleDao();
                    instance.ad = new AdDao();
                }
            }
        }
        return instance;
    }


        public void reset() {
            Reset.main(new String[0]);

    }
}


