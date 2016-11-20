package ru.innopolis.uni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        UserBean user = new UserBean();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        user = UserDAO.login(user);

        if (user.isValid()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("session", user);
            response.sendRedirect("userLogged.jsp");
        } else
            response.sendRedirect("invalidLogin.jsp");
    }

}


