package ru.innopolis.uni;

import ru.innopolis.uni.dao.LectionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.viktor on 26/11/2016.
 */
public class DeleteLection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        LectionDAO.deletLectionById(id);

        resp.sendRedirect("lectionlist.jsp");
    }
}
