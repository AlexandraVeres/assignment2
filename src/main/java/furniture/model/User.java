package main.java.furniture.model;

import main.java.furniture.enums.TipUser;

public class User {

    private int id;
    private String username;
    private String password;
    private String nume;
    private String email;
    private TipUser tip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipUser getTip() {
        return tip;
    }

    public void setTip(TipUser tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return nume;
    }
}
