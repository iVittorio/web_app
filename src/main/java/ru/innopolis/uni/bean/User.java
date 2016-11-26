package ru.innopolis.uni.bean;

import ru.innopolis.uni.constant.Role;
import ru.innopolis.uni.constant.Sex;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class User {
    private int id;
    private String login;
    private String fullName;
    private String email;
    private Sex sex;
    private Role role;

    public User() {
    }

    public User(int id, String login, String fullName, String email, Sex sex, Role role) {
        this.id = id;
        this.login = login;
        this.fullName = fullName;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", role=" + role +
                '}';
    }
}
