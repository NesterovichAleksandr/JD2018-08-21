package by.it.yaroshchuk.project.java.dao;

import by.it.yaroshchuk.project.java.dao.beansdao.*;

public class Dao {

    private static Dao instance;

    public UserDao user;
    public RoleDao role;
    public RequestDao request;
    public CompanyDao company;
    public ResumeDao resume;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        request = new RequestDao();
        company = new CompanyDao();
        resume = new ResumeDao();
    }

    public static Dao getDao() {
        if(instance == null) {
            synchronized (Dao.class) {
                instance = new Dao();
            }
        }
        return instance;
    }

    public void reset() {
        Reset.main(new String[0]);
    }
}
