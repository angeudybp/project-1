package Servlets;

import Hibernate.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");



        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ManagerDao managerDao = new ManagerDaoImp();

        List<Manager> managers = managerDao.getManagers();
        Manager manager = null;

        HttpSession session = req.getSession();

        for (Manager e: managers
        ) {
            if (e.getUsername().equals(username)&&e.getPassword().equals(password))
            {
                req.getRequestDispatcher("navbarManager.html").include(req,resp);
                session.setAttribute("uname",username);
                session.setAttribute("id",e.getId());
                printWriter.println("You've successfully logged in!");
                manager = e;
                e.setLogged(true);
                managerDao.updateManager(e);
            }
        }
        if (manager==null) {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/loginManager.html");
            requestDispatcher.include(req, resp);
            printWriter.println("Your credentials are incorrect!");
        }
        printWriter.close();

    }

}
