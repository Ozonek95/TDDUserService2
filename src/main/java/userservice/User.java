package userservice;

class User {
    private Login login;
    private Name name;
    private Surname surname;

    User(Login login, Name name, Surname surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    Login getLogin() {
        return login;
    }

    Name getName() {
        return name;
    }

    Surname getSurname() {
        return surname;
    }

    void setName(Name name) {
        this.name = name;
    }

    void setSurname(Surname surname) {
        this.surname = surname;
    }
}
