package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Эдуард on 02.08.15.
 */
public class ServletTariff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/tariffs.jsp").forward(req, resp);
//        resp.setContentType("text/html;charset=utf-8");
//      String string = req.getParameter("name");
//        PrintWriter pw = resp.getWriter();
//        pw.write("Hello,"+string);
//        pw.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
