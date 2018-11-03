package by.it.voinilo.project.java.entitydao;



import by.it.voinilo.project.java.beans.Ads;
import by.it.voinilo.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ads_Dao extends AbstractDao implements interfaceDao<Ads> {


    @Override
    public List<Ads> getALL(String WHERE) throws SQLException {
        List<Ads> ads = new ArrayList<>();
        String sql = "SELECT * FROM ads " + WHERE + " ;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Ads ad = new Ads();

                ad.setId(resultSet.getLong("id"));
                ad.setName(resultSet.getString("name"));
                ad.setAddress(resultSet.getString("address"));
                ad.setDescription(resultSet.getString("description"));
                ad.setCondition(resultSet.getString("condition"));
                ad.setNumber(resultSet.getString("number"));
                ad.setPrice(resultSet.getInt("price"));
                ad.setRoleparam_id(resultSet.getInt("roleparam_id"));
                ads.add(ad);
            }
            return ads;
        }
    }

    @Override
    public List<Ads> getALL() throws SQLException {
        return getALL( "");
    }
    @Override
    public boolean create(Ads ads) throws SQLException {


            String sql = String.format("INSERT INTO `ads`(`name`," +
                            " `address`, `description`, `condition`, `number`," +
                            " `price`, `roleparam_id`) VALUES ('%s','%s','%s','%s','%s','%d','%d')",
                    ads.getName(),ads.getAddress(),ads.getDescription(),ads.getCondition(),ads.getNumber(),ads.getPrice(),
                     ads.getRoleparam_id());
            long id = executeCreate(sql);
            if (id>0)ads.setId(id);
            return id>0;
    }


    @Override

    public Ads read(int id) throws SQLException {

        List<Ads> ads = getALL("WHERE ID=" + id + " LIMIT 0,1");

        if (ads.size() > 0) {
            return ads.get(0);

        } else
            return null;

    }

    @Override
    public boolean update(Ads ads) throws SQLException {

            String sql = String.format(
                    "UPDATE `ads` SET `name`='%s'," +
                            "`address`='%s',`description`='%s',`condition`='%s'," +
                            "`number`='%s',`price`='%s',`roleparam_id`='%d' WHERE `id`= %d;",
                    ads.getName(),ads.getAddress(),ads.getDescription(),ads.getCondition(),ads.getNumber(),ads.getPrice(),
                    ads.getRoleparam_id());
            return executeUpdate(sql);

    }

    @Override
    public boolean delete(Ads ads) throws SQLException {

            String sql = String.format("DELETE FROM `ads` WHERE `id` = %d;",
                    ads.getId());
            return executeUpdate(sql);

    }

//    public static void main(String[] args) throws SQLException {
//        Ads ads = new Ads(0,"well-worn nokia 3310",
//                "Makayonka 9", "Продам nokia 3310","5000$",
//                "battle-scared", "+375291112233" ,1 );
//        if (create(ads))
//            System.out.println("create is ok: " + ads );
//        long id = ads.getId();
//        ads = null;
//        ads = read(id);
//        if (ads!= null)
//            System.out.println("read is ok: " + ads);
//       ads.setCellnumber("==========================");
//        if (update(ads))
//            System.out.println("Update is Ok: "+ ads);
//        if (delete(ads))
//            System.out.println("delete is ok: " + ads);
//
//    }
}

