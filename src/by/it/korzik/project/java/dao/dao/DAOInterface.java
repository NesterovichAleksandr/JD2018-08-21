package by.it.korzik.project.java.dao.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
    T read(long id) throws SQLException;

    boolean create(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;

    List<T> getAll() throws SQLException;

    List<T> getAll(String condition) throws SQLException;

}
