package main.java.furniture.service;

import main.java.furniture.dao.UsersDao;
import main.java.furniture.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class UserService {

    private static User userAuthetificat = null;

    private UsersDao usersDao = new UsersDao();

    /**
     * Returneaza null daca user nu s-a putut autentifica, altfel returneaza userul authentificat
     * */
    public User authenticate(String username, String password) {
        User user = usersDao.cautaUser(username);
        if (user == null) {
            return null;
        }
        String passwordHash = hash(password);
        String hash = passwordHash != null ? passwordHash : "";
        if (hash.equals(user.getPassword())) {
            user.setPassword(null);
            userAuthetificat = user;
            return user;
        }
        return null;
    }

    public void createUser(User user) {
        user.setPassword(hash(user.getPassword()));
        usersDao.createUser(user);
    }

    private String hash(String password) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            String salt = "129382927juw82o";
            String passWithSalt = password + salt;
            byte[] passBytes = passWithSalt.getBytes();
            byte[] passHash = sha256.digest(passBytes);
            return Base64.getEncoder().encodeToString(passHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> list() {
        return usersDao.listeaza();
    }

    public void sterge(User user) {
        usersDao.sterge(user);
    }

    public void updateUser(User user) {
        user.setPassword(hash(user.getPassword()));
        usersDao.updateUser(user);
    }
}
