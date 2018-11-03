package by.it.kisielev.project6.java.dao;


import by.it.kisielev.project6.java.beans.Ad;
import by.it.kisielev.project6.java.beans.Role;
import by.it.kisielev.project6.java.dao.beansdao.CompaniDao;
import by.it.kisielev.project6.java.dao.beansdao.Reset;
import by.it.kisielev.project6.java.dao.beansdao.UniversalDAO;

public class Dao {
     private  static Dao instance;

     public CompaniDao compani;
     public Role role;
     public InterfaceDAO<Ad> ad;

     private Dao(){
         role= new Role();
         compani= new CompaniDao();
         ad= new UniversalDAO<>(new Ad(),"ads");

     }

     public static Dao getDao(){
         if(instance==null){
             synchronized (Dao.class){
                     instance=new Dao();
             }
         }
         return instance;
     }

     public  void reset(){
         Reset.main(new String[0]);
     }
}
