package ru.innopolis.uni.jdbc;

import java.sql.*;

/**
 * Created by i.viktor on 22/11/2016.
 */
public class JDBCConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:/Users/i.viktor/IdeaProjects/web_app/MyDBTest", "root", "root");
    }
}
