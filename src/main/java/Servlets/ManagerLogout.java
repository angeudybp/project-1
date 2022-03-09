package Servlets;

import Hibernate.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ManagerLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        req.getRequestDispatcher("index.html").include(req,resp);


        HttpSession session = req.getSession();
        int id = (Integer)session.getAttribute("id");
        ManagerDao managerDao = new ManagerDaoImp();
        Manager manager = managerDao.getManagerById(id);
        manager.setLogged(false);
        managerDao.updateManager(manager);


        session.setAttribute("uname","");
        session.setAttribute("id",0);
        printWriter.println("You Successfully logged out!");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
