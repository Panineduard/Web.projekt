package web;

import DAO.Sql.ServiseSQL;
import model.FlatOwner.Login;
import model.FlatOwner.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Эдуард on 07.08.15.
 */
public class ServletPersonalParlor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.getSession().setAttribute("my2", "session");
//        if(req.getParameter("name")==null){
//            req.setAttribute("my1", "req");
//            req.getSession().setAttribute("my2", "session");
//            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
//        }
//        else {
//
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();



       getServletContext().getRequestDispatcher("/notCorrektRegistration.jsp").forward(req, resp);

    }

}
