package by.it.kisielev.project6.java.dao;



import by.it.kisielev.project5.java.beans.Ad;
import by.it.kisielev.project5.java.beans.Compani;
import by.it.kisielev.project5.java.beans.Role;
import by.it.kisielev.project5.java.dao.Dao;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws  SQLException {
        by.it.kisielev.project5.java.dao.Dao dao= Dao.getDao();
        //dao.reset();

        Compani compani=new Compani(0,"CompaniDao", 1000,"CompaniDao", 72, 2);
        if(dao.compani.create(compani))
            System.out.println("CREATE:\n"+dao.compani.getAll());
        compani=dao.compani.read(compani.getId());
        compani.setAircraft("Duo224");
        if(dao.compani.update(compani))
            System.out.println("UPDATE:\n" + dao.compani.getAll());
        if(dao.compani.delete(compani))
            System.out.println("DELETE:\n"+dao.compani.getAll());

        Role role=new Role(0, "RoleDao");
        if(dao.role.create(role))
            System.out.println("CREATE:\n"+ role.getAll());
        role= dao.role.read(role.getId());
        role.setRole("BBBBBB");
        if (dao.role.update(role))
            System.out.println("UPDARE:\n"+ dao.role.getAll());
        if (dao.role.delete(role))
            System.out.println("DELETE:\n"+ dao.role.getAll());

        Ad ad=new Ad();
        ad.setAircraft("BioAir");
        ad.setComapani_id(2);
        if(dao.ad.create(ad))
            System.out.println("CREATE:\n" + dao.ad.getAll());
        ad= dao.ad.read(ad.getId());
        ad.setAircraft("GoodAirs");
        if (dao.ad.update(ad))
            System.out.println("UPDATE:\n" + dao.ad.getAll());
        if (dao.ad.delete(ad))
            System.out.println("DELETE:" + dao.ad.getAll());
    }
}
