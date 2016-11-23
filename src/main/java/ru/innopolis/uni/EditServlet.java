package ru.innopolis.uni;

import ru.innopolis.uni.UserBean;
import ru.innopolis.uni.UserDAO;
import ru.innopolis.uni.jdbc.JDBCConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by i.viktor on 23/11/2016.
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String family = req.getParameter("family");

        try {
            UserDAO userDAO = new UserDAO(JDBCConnection.getConnection());
            UserBean userBean = new UserBean.Builder(login).firstName(name).lastName(family).email(email).build();

            userDAO.edit(userBean);

            HttpSession session = req.getSession();
            session.setAttribute("bean", userBean);
            resp.sendRedirect("edit.jsp");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
