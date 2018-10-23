package userservice;

public class User {
    private Login login;
    private Name name;
    private Surname surname;

    public User(Login login, Name name, Surname surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public Login getLogin() {
        return login;
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }
}
