package ru.innopolis.uni;

import ru.innopolis.uni.jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCConnection.getConnection();

        Statement statement = connection.createStatement();

        statement.execute("CREATE TABLE users ()");
        statement.close();
        connection.close();
    }
}
