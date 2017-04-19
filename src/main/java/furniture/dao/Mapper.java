package main.java.furniture.dao;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

    T map(ResultSet resultSet) throws SQLException;

}
