package ru.innopolis.uni.constant;

/**
 * Created by i.viktor on 22/11/2016.
 */
public class Const {
    public static final String PREPARED_INSERT_QUERY = "INSERT INTO users(login, password, email, name, family, role) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String CHECK_USER_QUERY = "SELECT * FROM users WHERE login = ?";
    public static final String UPDATE_QUERY = "UPDATE USERS SET EMAIL=?, NAME=?, FAMILY=?, ROLE =? WHERE LOGIN =?";
}
