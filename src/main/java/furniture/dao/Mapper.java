package main.java.furniture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

    T map(ResultSet resultSet) throws SQLException;

}
