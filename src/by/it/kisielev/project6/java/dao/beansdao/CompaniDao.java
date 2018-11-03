package by.it.kisielev.project6.java.dao.beansdao;

import by.it.kisielev.project6.java.beans.Compani;
import by.it.kisielev.project6.java.dao.ConnectionCreator;
import by.it.kisielev.project6.java.dao.InterfaceDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompaniDao extends AbstractDao implements InterfaceDAO<Compani> {
    @Override
    public List<Compani> getAll(String WHERE)throws SQLException {
        List<Compani> companis =new ArrayList<>();
        String sql="SELECT * FROM users " + WHERE + " ;";
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            ResultSet rs= statement.executeQuery(sql);
            while(rs.next()){
                Compani compani=new Compani();
                compani.setId(rs.getLong("id"));
                compani.setAircraft(rs.getString("aircraft"));
                compani.setPassword(rs.getString("password"));
                compani.setPrace(rs.getInt("prace"));
                compani.setPlace(rs.getInt("place"));
                compani.setCompanis_id(rs.getInt("Compani_id"));
                companis.add(compani);
            }
            return companis;
        }
    }


    @Override
    public Compani read(long id) throws SQLException{
        List<Compani> companis=getAll("WHERE ID="+ id + "LIMIT 0,1");
        if (companis.size()>0){
            return companis.get(0);
        }else
            return null;
    }

    @Override
     public boolean create(Compani compani) throws SQLException {
        String sql= String.format(
                "insert INTO companis(aircraft,Password,compani_id)"+
                        "values('%s','%s','d');",
                compani.getAircraft(), compani.getPassword(),compani.getCompanis_id()
        );
        long id = executeUpdate(sql);
        if (id > 0) compani.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Compani compani)throws SQLException {
        String sql= String.format(
                "UPDATE `companis` SET `aircraft` = '%s', `password` = '%s', `compani_id` = '%d' WHERE `companis`.`id` = %d",
                compani.getAircraft(), compani.getPassword(),compani.getCompanis_id()
        );
        return (0<executeUpdate(sql));

    }

    @Override
    public boolean delete(Compani compani)throws SQLException {
            String sql = String.format(
                    "UPDATE `companis` WHERE `compani`.`ID` = %d;", compani.getId()
            );
            return (0< executeUpdate(sql));
        }

    @Override
    public List<Compani> getAll() throws SQLException {
        return getAll("");
    }
}
