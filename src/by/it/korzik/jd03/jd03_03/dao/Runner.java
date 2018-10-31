package by.it.korzik.jd03.jd03_03.dao;

import by.it.korzik.jd03.jd03_03.beans.Menu;
import by.it.korzik.jd03.jd03_03.beans.Orders;
import by.it.korzik.jd03.jd03_03.beans.Roles;
import by.it.korzik.jd03.jd03_03.beans.Users;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
        dao.reset();
        Users user = new Users(0,"rs","rrs","rrrsr","r@gmail.com",1);
        if (dao.user.create(user)){
            System.out.println("userCreate:"+ dao.user.getAll());
        }
        user=dao.user.read(user.getId());
        user.setLogin("edede");
        if (dao.user.update(user)){
            System.out.println("UPDATE:"+dao.user.getAll());
        }
        if (dao.user.delete(user))
            System.out.println("DELETE:\n" + dao.user.getAll());

        Roles role = new Roles(0, "RolesDao");
        if (dao.role.create(role))
            System.out.println("CREATE:\n" + dao.role.getAll());
        role = dao.role.read(role.getId());
        role.setRole("rrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:\n" + dao.role.getAll());
        if (dao.role.delete(role))
            System.out.println("DELETE:\n" + dao.role.getAll());

        Menu menu = new Menu(0,"as","as",2,1);
        if (dao.menu.create(menu)){
            System.out.println("CRE \n"+dao.menu.getAll());
        }
        menu=dao.menu.read(menu.getId());
        menu.setIngridients("sadsdasdasd");
        if (dao.menu.update(menu)){
            System.out.println("update\n"+dao.menu.getAll());
        }
        if (dao.menu.delete(menu)){
            System.out.println("DEL\n"+dao.menu.getAll());
        }

        Orders order = new Orders(0,1,1);
        if (dao.order.create(order)){
            System.out.println("CR"+dao.order.getAll());
        }
        order=dao.order.read(order.getId());
        order.setUsers_id(2);
        if (dao.order.update(order)){
            System.out.println("UPD\n"+dao.order.getAll());
        }
        if (dao.order.delete(order)){
            System.out.println("DEL\n"+dao.order.getAll());
        }
    }
}
