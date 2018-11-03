package by.it.kisielev.jd03_03;


import by.it.kisielev.jd03_03.beans.Ad;
import by.it.kisielev.jd03_03.entitydao.CompaniDao;
import by.it.kisielev.jd03_03.entitydao.Reset;
import by.it.kisielev.jd03_03.entitydao.RoleDao;

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
