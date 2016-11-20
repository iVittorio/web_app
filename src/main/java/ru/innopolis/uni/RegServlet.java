package ru.innopolis.uni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class RegServlet extends HttpServlet {
    private String firstName, lastName, email, username, password;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        firstName = req.getParameter("firstName");
        lastName = req.getParameter("lastName");
        email = req.getParameter("email");
        username = req.getParameter("username");
        password = req.getParameter("password");

        UserBean bean = new UserBean(username, password, firstName, lastName, email);

        boolean register = UserDAO.register(bean);
        if (register) {
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("invalidReg.jsp");
        }
    }
}
