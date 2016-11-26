package ru.innopolis.uni.dao;

import ru.innopolis.uni.bean.Lection;
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
 * Created by i.viktor on 26/11/2016.
 */
public class LectionDAO {

    public static List<Lection> getLections() {
        List<Lection> lections = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LECTIONS_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String text = resultSet.getString("text");
                lections.add(new Lection(id, name, text));
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return lections;
    }

    public static Lection getLectionById(int id) {
        Lection lection = null;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LECTION_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String text = resultSet.getString("text");
                lection = new Lection(id, name, text);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return lection;
    }

    public static void deletLectionById(int id) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LECTION_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    public static void addLection(Lection lection) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_LECTION_QUERY)) {
            preparedStatement.setString(1, lection.getName());
            preparedStatement.setString(2, lection.getText());
            preparedStatement.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    public static void editLection(Lection lection) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_LECTION_QUERY)) {
            preparedStatement.setString(1, lection.getName());
            preparedStatement.setString(2, lection.getText());
            preparedStatement.setInt(3, lection.getId());
            preparedStatement.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
