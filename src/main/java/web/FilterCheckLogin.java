package web;


import DAO.Sql.ServiseSQL;
import model.FlatOwner.Login;
import org.apache.catalina.filters.FilterBase;
import org.apache.juli.logging.Log;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.*;
import java.util.logging.Filter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.filters.FilterBase;
import org.apache.juli.logging.LogFactory;
import sun.net.httpserver.AuthFilter;


/**
 * Created by Эдуард on 01.08.15.
 */
public class FilterCheckLogin extends FilterBase {

    public static final Log log = LogFactory.getLog(AuthFilter.class);

    @Override
    protected Log getLogger() {
        return log;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String user = servletRequest.getParameter("user");
        String password = servletRequest.getParameter("password");
        if (user != null && !user.isEmpty() && password != null && !password.isEmpty()) {
            ServiseSQL serviseSQL = new ServiseSQL();

            Login login = new Login();
            login.setPassword(password);
            login.setUserName(user);
            try {
                String serviseReq = serviseSQL.getIdBylogin(login);
                if (serviseReq.equals("0")) {
                    HttpServletResponse resp = (HttpServletResponse) servletResponse;
                    resp.sendRedirect("/noData.jsp");
                } else {
                    servletResponse.getWriter().append("Hello ");
                    servletResponse.getWriter().append(serviseReq);
                    servletRequest.setAttribute("auth", new Auth(login.getUserName(), login.getPassword()));
                    filterChain.doFilter(servletRequest, servletResponse);
//                    HttpServletResponse resp = (HttpServletResponse) servletResponse;
//                    resp.sendRedirect("/personal_parlor.jsp");
                }
                servletResponse.getWriter().append(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//        filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().append("No auth");
        }
    }

    public static class Auth {
        private String login;
        private String name;

        public Auth(String name, String login) {
            this.login = login;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{Auth: " + this.login + "=" + this.name + "}";
        }
    }
}

