package ru.innopolis.uni;

import ru.innopolis.uni.bean.User;
import ru.innopolis.uni.constant.Role;
import ru.innopolis.uni.constant.Sex;
import ru.innopolis.uni.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by i.viktor on 23/11/2016.
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userID = (int) session.getAttribute("UserID");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        Sex sex = Sex.valueOf(req.getParameter("sex"));
        User user = new User(userID, login, fullName, email, sex, Role.STUDENT);
        UserDAO.editUser(user);

        resp.sendRedirect("edit.jsp");
    }
}
