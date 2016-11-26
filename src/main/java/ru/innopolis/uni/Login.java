package ru.innopolis.uni;

import ru.innopolis.uni.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class Login extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        int id = UserDAO.verifyLoginData(login, password);
        if (id > 0) {
            HttpSession session = request.getSession(true);
            session.setAttribute("UserID", id);
            response.sendRedirect("main.jsp");
        } else response.sendRedirect("invalidLogin.jsp");
    }
}