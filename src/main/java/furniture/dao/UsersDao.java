package main.java.furniture.dao;

import main.java.furniture.enums.TipUser;
import main.java.furniture.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UsersDao {

    public User cautaUser(String username) {
        try {
            return DataAccess.getInstance().execute("select * from users where username = ?", getMapper(), username);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Mapper<User> getMapper() {
        return new Mapper<User>() {

            public User map(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setNume(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
                user.setTip(TipUser.valueOf(resultSet.getString(6)));
                return user;
            }
        };
    }

    public List<User> listeaza() {
        try {
            return DataAccess.getInstance().list("select * from users", getMapper());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void createUser(User user) {
        try {
            String sql = "Insert into users (username, password, nume, email, tip) values (?, ?, ?, ? ,? ) ";
            DataAccess.getInstance().update(sql, new String[]{user.getUsername(), user.getPassword(),
                    user.getNume(), user.getEmail(), user.getTip().name()});
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void sterge(User user) {
        try {
            DataAccess.getInstance().update("delete from users where id = ?", new String[]{String.valueOf(user.getId())});
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void updateUser(User user) {
        try {
            DataAccess.getInstance().update("update users set " +
                    "username =?," +
                    "password=?," +
                    "nume=?," +
                    "email=?, " +
                    "tip=?" +
                    " where id = ?", new String[]{user.getUsername(), user.getPassword(),
                    user.getNume(), user.getEmail(), user.getTip().name(), String.valueOf(user.getId())});
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
