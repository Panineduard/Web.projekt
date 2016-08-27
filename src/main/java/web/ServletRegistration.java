package web;

import DAO.Sql.GenerationDb;
import DAO.Sql.ServiseSQL;
import model.FlatOwner.Login;
import model.FlatOwner.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Эдуард on 01.08.15.
 */
public class ServletRegistration extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      resp.setContentType("text/html;charset=utf-8");

      if(req.getParameter("name")==null){
          req.setAttribute("my1", "req");
          req.getSession().setAttribute("my2", "session");
         getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
      }
      else {

      }
  }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(!req.getParameter("name").isEmpty()&&!req.getParameter("firsname").isEmpty()&&!req.getParameter("lastname").isEmpty()&&
                !req.getParameter("telefon").isEmpty()&&!req.getParameter("email").isEmpty()&&!req.getParameter("pasword").isEmpty()&&
                !req.getParameter("login").isEmpty()) {
            if (req.getParameter("pasword").equals(req.getParameter("checkPasword"))) {
                Login login = new Login();
                Person person = new Person();
                person.setName(req.getParameter("name"));
                person.setFirstName(req.getParameter("firsname"));
                person.setLastName(req.getParameter("lastname"));
                person.setPhone(req.getParameter("telefon"));
                person.setEmail(req.getParameter("email"));
                login.setPassword(req.getParameter("pasword"));
                login.setUserName(req.getParameter("login"));
                person.setUserID(Integer.valueOf(req.getParameter("ID")));
                person.setLogin(login);
                ServiseSQL generationDb = new ServiseSQL();


                try {

                    if (generationDb.setPerson(person)) {
                        req.setAttribute("person", person.getUserID());
                        getServletContext().getRequestDispatcher("/successfulReg.jsp").forward(req, resp);
                    } else {

                        getServletContext().getRequestDispatcher("/notCorrektRegistration.jsp").forward(req, resp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                pw.close();
            }

            else {pw.write("Not correct pasword");
                pw.close();}

        }
        else {getServletContext().getRequestDispatcher("/notCorrektRegistration.jsp").forward(req, resp);}

        }

}
