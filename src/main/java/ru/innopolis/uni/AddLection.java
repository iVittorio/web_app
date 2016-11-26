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
public class AddLection extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String text = req.getParameter("text");
        LectionDAO.addLection(new Lection(0, name, text));

        resp.sendRedirect("lectionlist.jsp");
    }
}
