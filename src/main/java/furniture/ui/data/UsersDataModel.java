package main.java.furniture.ui.data;

import main.java.furniture.model.User;

import javax.swing.*;
import java.util.List;

public class UsersDataModel extends AbstractListModel<User>{

    private List<User> users;

    public UsersDataModel(List<User> users) {
        this.users = users;
    }

    public int getSize() {
        return users.size();
    }

    public User getElementAt(int i) {
        return users.get(i);
    }

    public void sterge(int index) {
        users.remove(index);
        fireContentsChanged(this, index, index);
    }
}
