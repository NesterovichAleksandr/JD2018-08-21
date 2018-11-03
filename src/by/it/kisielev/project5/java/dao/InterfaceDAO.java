package by.it.kisielev.project5.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<TYPE> {
    boolean create(TYPE entity) throws SQLException;
    TYPE read(long id) throws SQLException;
    boolean update(TYPE entity) throws SQLException;
    boolean delete(TYPE entity) throws SQLException;
    List<TYPE> getAll() throws SQLException;
    List<TYPE> getAll(String WHERE) throws SQLException;

}
