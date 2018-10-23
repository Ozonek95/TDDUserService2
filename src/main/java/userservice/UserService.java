package userservice;

import javax.activation.MimeTypeParameterList;
import java.util.ArrayList;
import java.util.List;

class UserService {

    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    boolean find(String name) {
        return false;
    }

    void add(String name, String surname, String login) {
        users.add(new User("name","surname","login"));
    }

    ArrayList<User> getUsers() {
        return users;
    }
}
