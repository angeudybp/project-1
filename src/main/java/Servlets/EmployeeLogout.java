package Servlets;

import Hibernate.Employee;
import Hibernate.EmployeeDao;
import Hibernate.EmployeeDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        req.getRequestDispatcher("index.html").include(req,resp);


        HttpSession session = req.getSession();
        int id = (Integer)session.getAttribute("id");
        EmployeeDao employeeDao = new EmployeeDaoImp();
        Employee employee = employeeDao.getEmployeeById(id);
        employee.setLogged(false);
        employeeDao.updateEmployee(employee);


        session.setAttribute("uname","");
        session.setAttribute("id",0);
        printWriter.println("<p>You Successfully logged out!</p>");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
