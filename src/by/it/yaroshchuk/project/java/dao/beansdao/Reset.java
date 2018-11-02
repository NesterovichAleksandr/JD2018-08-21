package by.it.yaroshchuk.project.java.dao.beansdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `hr` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `hr` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `hr`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE INDEX `role_UNIQUE` (`role` ASC))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `hr`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE INDEX `login_UNIQUE` (`login` ASC),\n" +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `hr`.`roles` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `hr`.`resumes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `full_name` VARCHAR(45) NULL,\n" +
                    "  `dob` TIMESTAMP(6) NULL,\n" +
                    "  `country` VARCHAR(45) NULL,\n" +
                    "  `city` VARCHAR(45) NULL,\n" +
                    "  `education` VARCHAR(45) NULL,\n" +
                    "  `degree` VARCHAR(45) NULL,\n" +
                    "  `graduate_year` INT NULL,\n" +
                    "  `experience` VARCHAR(45) NULL,\n" +
                    "  `post` VARCHAR(45) NULL,\n" +
                    "  `worktime` INT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_resumes_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_resumes_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `hr`.`users` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `hr`.`companies` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `company_name` VARCHAR(45) NULL,\n" +
                    "  `start_year` VARCHAR(45) NULL,\n" +
                    "  `about` VARCHAR(45) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_companies_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_companies_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `hr`.`users` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `hr`.`requests` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `message` MEDIUMTEXT NULL,\n" +
                    "  `companies_id` INT NOT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_requests_companies1_idx` (`companies_id` ASC),\n" +
                    "  INDEX `fk_requests_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_requests_companies1`\n" +
                    "    FOREIGN KEY (`companies_id`)\n" +
                    "    REFERENCES `hr`.`companies` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_requests_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `hr`.`users` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");

            //INSERT ROLES
            statement.executeUpdate("INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'company');");

            //INSERT USERS WITH ROLE USER
            statement.executeUpdate("INSERT INTO `hr`.`users` (`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT, 'user1', 'users1password', 'user1@gmail.com', '2');");
            statement.executeUpdate("INSERT INTO `hr`.`users` (`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT, 'user2', 'users1password', 'user2@gmail.com', '2');");
            statement.executeUpdate("INSERT INTO `hr`.`users` (`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT, 'veryStupidUser', 'stupidpassword', 'stupidStupid@gmail.com', '2');");

            //INSERT USERS WITH ROLE COMPANY
            statement.executeUpdate("INSERT INTO `hr`.`users` (`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT, 'company1', 'users1password', 'company1@gmail.com', '3');");
            statement.executeUpdate("INSERT INTO `hr`.`users` (`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT, 'company2', 'users1password', 'company2@gmail.com', '3');");
            statement.executeUpdate("INSERT INTO `hr`.`users` (`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT, 'blah', 'users1password', 'blah@gmail.com', '3');");

            //INSERT RESUMES
            statement.executeUpdate("INSERT INTO `hr`.`resumes` " +
                    "(`id`, `full_name`, `dob`, `country`, `city`, `education`, `degree`, " +
                    "`graduate_year`, `experience`, `post`, `worktime`, `users_id`) " +
                    "VALUES (NULL, 'Full Name1', '1992-10-25 00:00:00.000000', 'Country1', " +
                    "'City1', 'University name1', 'some degree', '2015', 'Company name1', " +
                    "'some post', '2', '1');");
            statement.executeUpdate("INSERT INTO `hr`.`resumes` " +
                    "(`id`, `full_name`, `dob`, `country`, `city`, `education`, `degree`, " +
                    "`graduate_year`, `experience`, `post`, `worktime`, `users_id`) " +
                    "VALUES (NULL, 'Full Name2', '1992-10-25 00:00:00.000000', 'Country2', " +
                    "'City2', 'University name2', 'some degree', '2015', 'Company name2', " +
                    "'some post', '2', '2');");

            //INSERT COMPANIES
            statement.executeUpdate("INSERT INTO `hr`.`companies` " +
                    "(`id`, `company_name`, `start_year`, `about`, `users_id`)" +
                    "VALUES (NULL, 'company_name1', '2007', 'about1', '4')");
            statement.executeUpdate("INSERT INTO `hr`.`companies` " +
                    "(`id`, `company_name`, `start_year`, `about`, `users_id`)" +
                    "VALUES (NULL, 'company_name2', '2007', 'about2', '5')");
            statement.executeUpdate("INSERT INTO `hr`.`companies` " +
                    "(`id`, `company_name`, `start_year`, `about`, `users_id`)" +
                    "VALUES (NULL, 'blah blah  company', '2010', 'blahblahblahblahblahblahblah', '6')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
