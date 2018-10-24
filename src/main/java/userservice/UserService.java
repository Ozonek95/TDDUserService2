package userservice;

import java.util.ArrayList;

class UserService {

    private LoginValidator loginValidator;

    private ArrayList<User> users;


    UserService(LoginValidator loginValidator) {

        users = new ArrayList<>();
        this.loginValidator = loginValidator;
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
        if(loginValidator.validate(login)) {
            for (User user : users) {
                if (user.getLogin().getLogin().equals(login)) {
                    throw new LoginException("Login already exists");
                }
            }
            User user = new User(new Login(login), new Name(name), new Surname(surname));
            users.add(user);
        }
        else throw new LoginException("Invalid login!");
    }

    ArrayList<User> getUsers() {
        return users;
    }

    void update(String login, Name name) throws LoginException {

        find(login).setName(name);
    }

    void update(String login, Surname surname) throws LoginException {
        find(login).setSurname(surname);
    }

    void delete(String login) {
        for (int i=0;i<users.size();i++){
            if(users.get(i).getLogin().getLogin().equals(login)){
                users.remove(i);
            }
        }
    }
}
