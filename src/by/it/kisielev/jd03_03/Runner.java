package by.it.kisielev.jd03_03;

import by.it.kisielev.jd03_03.beans.Ad;
import by.it.kisielev.jd03_03.beans.Role;
import by.it.kisielev.jd03_03.entitydao.CompaniDao;
import by.it.kisielev.jd03_03.beans.Compani;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args)  throws  SQLException {
        Dao dao=Dao.getDao();
        //dao.reset();

        Compani compani=new Compani(0,"AirBRO","AirBRO", 2);
        if(dao.compani.create(compani))
            System.out.println("CREATE:\n"+dao.compani.getAll());
        compani=dao.compani.read(compani.getId());
        compani.setCompani("Duo224Compani");
        if(dao.compani.update(compani))
            System.out.println("UPDATE:\n" + dao.compani.getAll());
        if(dao.compani.delete(compani))
            System.out.println("DELETE:\n"+dao.compani.getAll());

        Role role=new Role(0, "RoleDao");
        if(dao.role.create(role))
            System.out.println("CREATE:\n"+ dao.role.getAll());
        role= dao.role.read(role.getId());
        role.setRole("Compani");
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