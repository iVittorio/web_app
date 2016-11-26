package ru.innopolis.uni.jdbc;


import java.sql.*;
import javax.naming.*;
import javax.sql.*;

/**
 * Created by i.viktor on 22/11/2016.
 */
public class JDBCConnection {

    public static Connection getConnection() throws NamingException, SQLException {
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/MyDBTest"); // вместо написать java:/comp/env/jdbc/TestDB
        return ds.getConnection();

    }
}
