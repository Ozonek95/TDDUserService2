package userservice;

import java.util.ArrayList;

class UserService {

    private ArrayList<User> users;

    UserService() {
        users = new ArrayList<>();
    }

    User find(String login) throws LoginException {
        for (User user:users) {
            if(user.getLogin().getLogin().equals(login)){
                return user;
            }
        }
        throw new LoginException("User cannot be found");
    }

    void add(String login, String name, String surname) throws LoginException {
        for (User user:users) {
            if(user.getLogin().getLogin().equals(login)){
                throw new LoginException("Login already exists");
            }
        }
        User user = new User(new Login(login),new Name(name), new Surname(surname));
        users.add(user);
    }

    ArrayList<User> getUsers() {
        return users;
    }

    public void update(String login, Name name) throws LoginException {

        find(login).setName(name);
    }

    void update(String login, Surname surname) throws LoginException {
        find(login).setSurname(surname);
    }

    public void delete(String login) {
    }
}
