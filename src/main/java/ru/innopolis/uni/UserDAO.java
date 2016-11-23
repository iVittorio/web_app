package ru.innopolis.uni;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.innopolis.uni.constant.Const.*;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class UserDAO {
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }


    public UserBean login(String login, String password) {
        UserBean result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_QUERY);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nameFromDB = resultSet.getString("login");
                String passFromDB = resultSet.getString("password");


                if (login.equals(nameFromDB) && md5Apache(password).equals(passFromDB)) {
                    result = new UserBean.Builder(login).firstName(resultSet.getString("name")).email(resultSet.getString("email")).lastName(resultSet.getString("family")).role(resultSet.getString("role")).build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean register(UserBean bean, String password) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PREPARED_INSERT_QUERY);
            preparedStatement.setString(1, bean.getLogin());
            preparedStatement.setString(2, md5Apache(password));
            preparedStatement.setString(3, bean.getEmail());
            preparedStatement.setString(4, bean.getName());
            preparedStatement.setString(5, bean.getFamily());
            preparedStatement.setString(6, bean.getRole());
            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean edit(UserBean bean) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, bean.getEmail());
            preparedStatement.setString(2, bean.getName());
            preparedStatement.setString(3, bean.getFamily());
            preparedStatement.setString(4, bean.getRole());
            preparedStatement.setString(5, bean.getLogin());
            int i = preparedStatement.executeUpdate();
            System.out.println("DEBUG: " + bean);
            System.out.println("DEBUG: " + i);
            if (i != 0) {
                System.out.println("DEBUG: " + i);
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }
}
