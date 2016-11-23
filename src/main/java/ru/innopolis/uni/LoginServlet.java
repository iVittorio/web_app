package ru.innopolis.uni;

import org.apache.commons.codec.digest.DigestUtils;
import ru.innopolis.uni.jdbc.JDBCConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class LoginServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");



        try {
            UserDAO dao = new UserDAO(JDBCConnection.getConnection());

            UserBean bean = dao.login(login, password);

            if (bean != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("bean", bean);
                response.sendRedirect("edit.jsp");
            } else response.sendRedirect("invalidLogin.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


