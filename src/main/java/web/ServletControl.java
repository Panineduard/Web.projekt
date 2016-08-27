package web;

/**
 * Created by Эдуард on 30.07.15.
 */
import DAO.Sql.ServiseSQL;
import Servise.Count;
import Servise.Storage;
import model.Flat.Adress;
import model.Tariff.Tariff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServletControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        if (req.getParameter("data").isEmpty()) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            if (req.getParameter("cotype").equals("counter")) {
                  ServiseSQL serviseSQL = new ServiseSQL();
                     Tariff tariff = new Tariff();
                try {
                    tariff = serviseSQL.getDebtByIdFlst(req.getParameter("data"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Count count = new Count();
                            req.setAttribute("gas", tariff.getGas());
                            req.setAttribute("hating", tariff.getHeating());
                            req.setAttribute("electricpower", tariff.getElectricPower());
                            req.setAttribute("hotwater", tariff.getHotWater());
                            req.setAttribute("coldwater", tariff.getColdWater());
                            req.setAttribute("sewerage", tariff.getSewerage());
                            req.setAttribute("rent", tariff.getRent());
                            req.setAttribute("garbageremoval", tariff.getGarbageRemoval());
                            req.setAttribute("all", count.TotalCost(tariff));//count.TotalCost(tariff)
                            getServletContext().getRequestDispatcher("/showDebts.jsp").forward(req, resp);

                        }

            if (req.getParameter("cotype").equals("adress")) {
                Adress adress = new Adress();
                adress.setCity(req.getParameter("data"));
                Storage.getInstance().putToStorage(1, adress.getCity());

                req.setAttribute("my1", adress.getCity());
                getServletContext().getRequestDispatcher("/searchByAddress.jsp").forward(req, resp);
            }
            if (req.getParameter("cotype").equals("lastname")) {
                ServiseSQL serviseSQL = new ServiseSQL();
                String lastname = req.getParameter("data");

                Storage.getInstance().putToStorage(2, lastname);
                List<Integer> idFlats = new ArrayList<Integer>();

                try {
                    idFlats = serviseSQL.getIdFlatsByLastname(lastname);
                    if (idFlats.size() > 1) {
                        req.setAttribute("lastname", Storage.getInstance().getById(2));
                        getServletContext().getRequestDispatcher("/ask_the_person.jsp").forward(req, resp);
                    }
                    if (idFlats.size() == 1) {
                        Tariff tariff = new Tariff();
                        Count count = new Count();
                        tariff = serviseSQL.getDebtByIdFlst(idFlats.get(0).toString());
                        req.setAttribute("gas", tariff.getGas());
                        req.setAttribute("hating", tariff.getHeating());
                        req.setAttribute("electricpower", tariff.getElectricPower());
                        req.setAttribute("hotwater", tariff.getHotWater());
                        req.setAttribute("coldwater", tariff.getColdWater());
                        req.setAttribute("sewerage", tariff.getSewerage());
                        req.setAttribute("rent", tariff.getRent());
                        req.setAttribute("garbageremoval", tariff.getGarbageRemoval());
                        req.setAttribute("all", count.TotalCost(tariff));
                        getServletContext().getRequestDispatcher("/showDebts.jsp").forward(req, resp);
                    }
                    if (idFlats.size() == 0) {
                        getServletContext().getRequestDispatcher("/noData.jsp").forward(req, resp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (!req.getParameter("strit").isEmpty() && !req.getParameter("nohouse").isEmpty() && !req.getParameter("namberflat").isEmpty()) {
            Adress adress = new Adress();
//            adress= (Adress)Storage.getInstance().getById(1);
            adress.setCity((String) Storage.getInstance().getById(1));
            adress.setStreet(req.getParameter("strit"));
            adress.setNoHouse(Integer.valueOf(req.getParameter("nohouse")));
            adress.setNamberFlat(Integer.valueOf(req.getParameter("namberflat")));
            ServiseSQL serviseSQL = new ServiseSQL();

            try {
                Tariff tariff = new Tariff();
                Count count = new Count();

                tariff = serviseSQL.getDebts(adress);
                req.setAttribute("gas", tariff.getGas());
                req.setAttribute("hating", tariff.getHeating());
                req.setAttribute("electricpower", tariff.getElectricPower());
                req.setAttribute("hotwater", tariff.getHotWater());
                req.setAttribute("coldwater", tariff.getColdWater());
                req.setAttribute("sewerage", tariff.getSewerage());
                req.setAttribute("rent", tariff.getRent());
                req.setAttribute("garbageremoval", tariff.getGarbageRemoval());
                req.setAttribute("all", count.TotalCost(tariff));
                getServletContext().getRequestDispatcher("/showDebts.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            getServletContext().getRequestDispatcher("/noData.jsp").forward(req, resp);
        }

    }
}
