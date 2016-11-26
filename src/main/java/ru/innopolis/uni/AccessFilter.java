package ru.innopolis.uni;

import ru.innopolis.uni.bean.User;
import ru.innopolis.uni.constant.Role;
import ru.innopolis.uni.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by i.viktor on 26/11/2016.
 */
public class AccessFilter implements Filter {
    private FilterConfig filterConfig;

    public void setFilterConfig(FilterConfig fc) {
        filterConfig = fc;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (filterConfig == null) {
            return;
        }

        ServletContext ctx = filterConfig.getServletContext();

        int userID = (int) ((HttpServletRequest) request).getSession().getAttribute("UserID");
        User user = UserDAO.getUserById(userID);
        Role userRole = user.getRole();

        String requestURI = ((HttpServletRequest) request).getRequestURI();

        if (userRole.equals(Role.TEACHER)) {
            RequestDispatcher dispatcher = ctx.getRequestDispatcher(requestURI);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/main.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
