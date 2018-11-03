package by.it.kisielev.jd03_03.entitydao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {

    //в init-классы должны быть свои собственные настройки mysql
    //т.к. самой базы пока может и не быть!!!
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/"+
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void main(String[] args) {
        //наиболее надежный способ загрузки драйвера
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }


        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB)
        ) {
            Statement statement=connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kisielev` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kisielev` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `kisielev`.`role` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `role` VARCHAR(50) NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "ENGINE = InnoDB;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `kisielev`.`companis` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `compani` VARCHAR(45) NULL,\n" +
                            "  `password` VARCHAR(45) NULL,\n" +
                            "  `role_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_companis_role2_idx` (`role_id` ASC),\n" +
                            "  CONSTRAINT `fk_companis_role2`\n" +
                            "    FOREIGN KEY (`role_id`)\n" +
                            "    REFERENCES `kisielev`.`role` (`id`)\n" +
                            "    ON DELETE RESTRICT\n" +
                            "    ON UPDATE RESTRICT)\n" +
                            "ENGINE = InnoDB;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `kisielev`.`aircraft` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `aircraft` VARCHAR(45) NULL,\n" +
                            "  `prace` INT NULL,\n" +
                            "  `place` INT NULL,\n" +
                            "  `companis_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_table1_companis1_idx` (`companis_id` ASC),\n" +
                            "  CONSTRAINT `fk_table1_companis1`\n" +
                            "    FOREIGN KEY (`companis_id`)\n" +
                            "    REFERENCES `kisielev`.`companis` (`id`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE)\n" +
                            "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `kisielev`.`role` (`id`, `role`) VALUES (DEFAULT, 'Admin');");
            statement.executeUpdate("INSERT INTO `kisielev`.`role` (`id`, `role`) VALUES (DEFAULT, Compani)");
            statement.executeUpdate("INSERT INTO `kisielev`.`role` (`id`, `role`) VALUES (DEFAULT, 'Guest')");
            statement.executeUpdate("INSERT INTO `kisielev`.`companis` (`id`, `compani`, `password`, `role_id`) VALUES (DEFAULT, 'admin', 'admin123', 1);");
            statement.executeUpdate("INSERT INTO `kisielev`.`companis` (`id`, `compani`, `password`, `role_id`) VALUES (DEFAULT, 'user', 'user', 2;");
            statement.executeUpdate("INSERT INTO `kisielev`.`aircraft` (`id`, `aircraft`, `prace`, `place`, `companis_id`) VALUES (DEFAULT, 'Ту-134', 1500, 72, 2);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}