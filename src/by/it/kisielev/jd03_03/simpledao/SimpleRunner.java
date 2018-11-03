package by.it.kisielev.jd03_03.simpledao;


import by.it.kisielev.jd03_03.beans.Ad;
import by.it.kisielev.jd03_03.beans.Role;
import by.it.kisielev.jd03_03.beans.Compani;

import java.sql.SQLException;

public class SimpleRunner {


    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.INSTANCE;

        Compani compani = new Compani(0, "CompaniDao", "CompaniDao", 2);
        if (dao.user.create(compani))
            System.out.println("CREATE:\n" + dao.user.getAll());
        compani = dao.user.read(compani.getId());
        compani.setCompani("uuuuuu");
        if (dao.user.update(compani))
            System.out.println("UPDATE:\n" + dao.user.getAll());
        if (dao.user.delete(compani))
            System.out.println("DELETE:\n" + dao.user.getAll());

        Role role = new Role(0, "RoleDao");
        if (dao.role.create(role))
            System.out.println("CREATE:\n" + dao.role.getAll());
        role = dao.role.read(role.getId());
        role.setRole("rrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:\n" + dao.role.getAll());
        if (dao.role.delete(role))
            System.out.println("DELETE:\n" + dao.role.getAll());

        Ad ad = new Ad();
        ad.setAircraft("Ty-142 ");
        ad.setComapani_id(2);
        if (dao.ad.create(ad))
            System.out.println("CREATE:\n" + dao.ad.getAll());
        ad = dao.ad.read(ad.getId());
        ad.setAircraft("Ty-11111");
        if (dao.ad.update(ad))
            System.out.println("UPDATE:\n" + dao.ad.getAll());
        if (dao.ad.delete(ad))
            System.out.println("DELETE:" + dao.ad.getAll());
    }
}