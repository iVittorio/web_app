package ru.innopolis.uni.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import ru.innopolis.uni.bean.User;
import ru.innopolis.uni.constant.Role;
import ru.innopolis.uni.constant.Sex;
import ru.innopolis.uni.jdbc.JDBCConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.uni.constant.Const.*;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class UserDAO {
    Logger logger = Logger.getLogger(UserDAO.class);

    public static int verifyLoginData(String login, String password) {
        int result = -1;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VERIFY_LOGIN_DATA_QUERY)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idFromDB = resultSet.getInt("ID");
                String passFromDB = resultSet.getString("PASSWORD");
                if (DigestUtils.md5Hex(password).equals(passFromDB)) {
                    result = idFromDB;
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean addUser(User user, String password) {
        boolean result = false;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getSex().toString());
            preparedStatement.setString(6, user.getRole().toString());
            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                result = true;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean deleteUserById(int id) {
        boolean result = false;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                result = true;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static User getUserById(int id) {
        User user = null;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString("LOGIN");
                String fullName = resultSet.getString("FULLNAME");
                String email = resultSet.getString("EMAIL");
                Sex sex = Sex.valueOf(resultSet.getString("SEX"));
                Role role = Role.valueOf(resultSet.getString("ROLE"));
                user = new User(id, login, fullName, email, sex, role);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean editUser(User user) {
        boolean result = false;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_STUDENT_QUERY)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getSex().toString());
            preparedStatement.setString(4, user.getRole().toString());
            preparedStatement.setInt(5, user.getId());
            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                result = true;
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<User> getUsers() {
        List<User> list = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullame = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String sex = resultSet.getString("sex");
                String role = resultSet.getString("role");
                String login = resultSet.getString("login");

                list.add(new User(id, login, fullame, email, Sex.valueOf(sex), Role.valueOf(role)));
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }
}
