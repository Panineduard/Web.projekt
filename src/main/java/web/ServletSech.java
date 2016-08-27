package web;

import DAO.Sql.GenerationDb;
import DAO.Sql.ServiseSQL;
import Servise.Count;
import Servise.Storage;
import model.Flat.Adress;
import model.FlatOwner.Login;
import model.FlatOwner.Person;
import model.Tariff.Tariff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Эдуард on 07.08.15.
 */
public class ServletSech extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");


        if(req.getParameter("data").isEmpty()) {
            getServletContext().getRequestDispatcher("/noData.jsp").forward(req, resp);
        }
        else {

                    ServiseSQL serviseSQL=new ServiseSQL();
                   List<Tariff> tariffs =new ArrayList<Tariff>();
            try {
                tariffs=serviseSQL.getDebtByInn(req.getParameter("data"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(tariffs.size()==1){
                            Tariff tariff=new Tariff();
                            Count count=new Count();
                            tariff=tariffs.get(0) ;

                            req.setAttribute("gas", tariff.getGas());
                            req.setAttribute("hating", tariff.getHeating());
                            req.setAttribute("electricpower", tariff.getElectricPower());
                            req.setAttribute("hotwater", tariff.getHotWater());
                            req.setAttribute("coldwater", tariff.getColdWater());
                            req.setAttribute("sewerage", tariff.getSewerage());
                            req.setAttribute("rent", tariff.getRent());
                            req.setAttribute("garbageremoval",tariff.getGarbageRemoval());
                            req.setAttribute("all",count.TotalCost(tariff));//count.TotalCost(tariff)
                            getServletContext().getRequestDispatcher("/showDebts.jsp").forward(req, resp);

                        }}






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

getServletContext().getRequestDispatcher("/noData.jsp").forward(req, resp);}

    }
