package ua.nure.garmash.Practice8.entity;

public class User {
    private String login;
    private int id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User [id = " + id + ", login = " + login + "]";
    }
    public static User createUser (String login) {
        User user = new User();
        user.setLogin(login);
        return user;
    }

}
