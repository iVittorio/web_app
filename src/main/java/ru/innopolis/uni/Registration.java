package ru.innopolis.uni;

import ru.innopolis.uni.bean.User;
import ru.innopolis.uni.constant.Role;
import ru.innopolis.uni.constant.Sex;
import ru.innopolis.uni.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        Sex sex = Sex.valueOf(req.getParameter("sex"));
        Role role = Role.STUDENT;

        User user = new User(0, login, fullName, email, sex, role);

        int loginData = UserDAO.verifyLoginData(login, password);

        UserDAO.addUser(user, password);
        resp.sendRedirect("index.jsp");
    }
}
