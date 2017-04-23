package main.java.furniture.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

    private static final DataAccess instance = new DataAccess();

    private MysqlDataSource dataSource;

    public static DataAccess getInstance() {
        return instance; // asta ii un Singleton, ceea ce inseamna ca exista o singura instanta a acestei clase
    }

    private DataAccess() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("app");
        dataSource.setPassword("app");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("furniture");
    }

    public <T> List<T> list(String sql, Mapper<T> mapper, String... params) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 1; i <= params.length; i++) {
                preparedStatement.setObject(i, params[i - 1]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> result = new ArrayList<T>();
        while (resultSet.next()) {
            T t = mapper.map(resultSet);
            result.add(t);
        }
        connection.close();
        return result;
    }

    public <T> T execute(String sql, Mapper<T> mapper, String... params) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 1; i <= params.length; i++) {
                preparedStatement.setObject(i, params[i - 1]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        T mapResult = null;
        if (resultSet.next()) {
            mapResult = mapper.map(resultSet);
        }
        connection.close();
        return mapResult;
    }


    public void update(String sql, Object[] data) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (data != null && data.length > 0) {
            for (int i = 1; i <= data.length; i++) {
                preparedStatement.setObject(i, data[i - 1]);
            }
        }
        preparedStatement.executeUpdate();
        connection.close();
    }

}
