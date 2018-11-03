package by.it.korzik.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static String USER_DB = "root";
    private static String PASSWORD_DB = "";


    public static void main(String[] args) {
        init();
    }

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }


        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `korzik` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `korzik` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korzik`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korzik`.`Users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `userName` VARCHAR(45) NULL,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(50) NULL,\n" +
                    "  `email` VARCHAR(60) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Person_roles1_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_Person_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `korzik`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korzik`.`menu` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(60) NULL,\n" +
                    "  `ingridients` VARCHAR(200) NULL,\n" +
                    "  `weight` FLOAT NULL,\n" +
                    "  `price` FLOAT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korzik`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Users_id` INT NOT NULL,\n" +
                    "  `menu_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_Users1_idx` (`Users_id` ASC),\n" +
                    "  INDEX `fk_orders_menu1_idx` (`menu_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_Users1`\n" +
                    "    FOREIGN KEY (`Users_id`)\n" +
                    "    REFERENCES `korzik`.`Users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_orders_menu1`\n" +
                    "    FOREIGN KEY (`menu_id`)\n" +
                    "    REFERENCES `korzik`.`menu` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'cook');");
            statement.executeUpdate("INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'customer');");
            statement.executeUpdate("INSERT INTO `korzik`.`Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'administrator', 'admin', 'iamadministrator', 'admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `korzik`.`Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'customer', 'customer', 'iamcustomer', 'customer@gmail.com', 3);");
            statement.executeUpdate("INSERT INTO `korzik`.`Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'cook', 'cook', 'cook', 'cook@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `korzik`.`menu` (`id`, `name`, `ingridients`, `weight`, `price`) VALUES (DEFAULT, 'something', 'some ingridients', 150, 14);");
            statement.executeUpdate("INSERT INTO `korzik`.`menu` (`id`, `name`, `ingridients`, `weight`, `price`) VALUES (DEFAULT, 'anything', 'anything', 223, 12);");
            statement.executeUpdate("INSERT INTO `korzik`.`orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 1, 1);");
            statement.executeUpdate("INSERT INTO `korzik`.`orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 2, 2);");
            statement.executeUpdate("INSERT INTO `korzik`.`orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 2, 1);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
