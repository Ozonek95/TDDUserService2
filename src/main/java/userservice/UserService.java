package userservice;

import java.util.ArrayList;

class UserService {

    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    User find(String login) {
        for (User user:users) {
            if(user.getLogin().getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    void add(String login, String name, String surname) {
        User user = new User(new Login(login),new Name(name), new Surname(surname));
        users.add(user);
    }

    ArrayList<User> getUsers() {
        return users;
    }

    public void update(String login, Name name) {

        find(login).setName(name);
    }

    public void update(String login, Surname surname){
        find(login).setSurname(surname);
    }
}
