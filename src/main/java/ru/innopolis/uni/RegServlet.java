package ru.innopolis.uni;

import ru.innopolis.uni.jdbc.JDBCConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        UserBean userBean = new UserBean.Builder(login).firstName(firstName).lastName(lastName).email(email).build();

        try {
            UserDAO userDAO = new UserDAO(JDBCConnection.getConnection());
            boolean register = userDAO.register(userBean, password);
            if (register) {
                resp.sendRedirect("index.jsp");
            } else {
                resp.sendRedirect("invalidReg.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
