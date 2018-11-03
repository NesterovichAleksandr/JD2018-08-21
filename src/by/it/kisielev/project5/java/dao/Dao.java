package by.it.kisielev.project5.java.dao;


import by.it.kisielev.project5.java.beans.Ad;
import by.it.kisielev.project5.java.dao.beansdao.Reset;
import by.it.kisielev.project5.java.dao.beansdao.RoleDao;
import by.it.kisielev.project5.java.dao.beansdao.CompaniDao;



class Dao {
    private  static Dao instance;

    public CompaniDao compani;
    public RoleDao role;
    public InterfaceDao<Ad> ad;

    private Dao(){
        role = new RoleDao();
        compani= new CompaniDao();
        ad=new UniversalDAO<>(new Ad(), "ads");
    }

    static Dao getDao(){
        if(instance==null){
            synchronized (Dao.class){
                instance=new Dao();

            }
        }
        return instance;
    }
    public void reset(){ Reset.main(new String[0]);}
}
