package by.it.korzik.project.java.dao.beans;

import java.util.Objects;

public class Users {
    private long id;
    private String userName;
    private String login;
    private String password;
    private String email;
    private long roles_id;




    public Users(long id, String userName, String login, String password, String email, long roles_id) {

        this.id = id;
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(userName, users.userName) &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) &&
                Objects.equals(email, users.email) &&
                Objects.equals(roles_id, users.roles_id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, login, password, email, roles_id);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_id='" + roles_id + '\'' +
                '}';
    }
}
