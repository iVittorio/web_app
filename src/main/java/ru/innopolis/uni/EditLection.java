package ru.innopolis.uni;

import ru.innopolis.uni.bean.Lection;
import ru.innopolis.uni.dao.LectionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.viktor on 26/11/2016.
 */
public class EditLection extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String text = req.getParameter("text");

        LectionDAO.editLection(new Lection(id, name, text));

        resp.sendRedirect("lectionlist.jsp");
    }
}
