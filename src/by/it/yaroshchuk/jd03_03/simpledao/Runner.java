package by.it.yaroshchuk.jd03_03.simpledao;

import by.it.yaroshchuk.jd03_03.beans.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        //dao.reset();
        
        
        //check UserDao
        User user = new User(0, "DaoUser", "DaoUser", "DaoUser@gmail.com",2);
        System.out.println("\nROLE");
        if(dao.user.create(user))
            System.out.println("CREATE USER: \n" + dao.user.getAll());
        user = dao.user.read(user.getId());
        user.setPassword("newPassword");
        if(dao.user.update(user))
            System.out.println("UPDATE USER: \n" + dao.user.getAll());
        if(dao.user.delete(user))
                System.out.println("DELETE USER: \n" + dao.user.getAll());
        
        //check RoleDao
        Role role = new Role(0, "DaoRole");
        System.out.println("\nROLE");
        if(dao.role.create(role))
            System.out.println("CREATE ROLE: \n" + dao.role.getAll());
        role = dao.role.read(role.getId());
        role.setRole("newDaoRole");
        if(dao.role.update(role))
            System.out.println("UPDATE ROLE: \n" + dao.role.getAll());
        if(dao.role.delete(role))
            System.out.println("DELETE ROLE: \n" + dao.role.getAll());

        //check CompanyDao
        Company company = new Company(0, "DaoCompany", "2003", "about DaoCompany",3);
        System.out.println("\nCOMPANY");
        if(dao.company.create(company))
            System.out.println("CREATE COMPANY: \n" + dao.company.getAll());
        company = dao.company.read(company.getId());
        company.setAbout("NEW daocompany about");
        if(dao.company.update(company))
            System.out.println("UPDATE COMPANY: \n" + dao.company.getAll());
        if(dao.company.delete(company))
            System.out.println("DELETE COMPANY: \n" + dao.company.getAll());

        //check RequestDao
        Request request = new Request(0, "DaoRequestMessage", 1, 2);
        System.out.println("\nREQUEST");
        if(dao.request.create(request))
            System.out.println("CREATE REQUEST: \n" + dao.request.getAll());
        request = dao.request.read(request.getId());
        request.setMessage("NEW DaoRequestMessage");
        if(dao.request.update(request))
            System.out.println("UPDATE REQUEST: \n" + dao.request.getAll());
        if(dao.request.delete(request))
            System.out.println("DELETE REQUEST: \n" + dao.request.getAll());
        
        //check Resume
        Resume resume = new Resume(0, "DaoFullName",
                "1992-10-12",
                "DaoCountry", "DaoCity", "DaoEducation", "DaoDegree",
                2008, "DaoExperience", "DaoPost", 2, 2);
        System.out.println("\nROLE");
        if(dao.resume.create(resume))
            System.out.println("CREATE USER: \n" + dao.resume.getAll());
        resume = dao.resume.read(resume.getId());
        resume.setCountry("aaaaaaaaaaaaaaaaa22222");
        if(dao.resume.update(resume))
            System.out.println("UPDATE USER: \n" + dao.resume.getAll());
        if(dao.resume.delete(resume))
            System.out.println("DELETE USER: \n" + dao.resume.getAll());
    }
}
