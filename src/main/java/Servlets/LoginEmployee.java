package Servlets;

import Hibernate.Employee;
import Hibernate.EmployeeDao;
import Hibernate.EmployeeDaoImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");



        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        EmployeeDao employeeDao = new EmployeeDaoImp();

        List<Employee> employees = employeeDao.getEmployees();
        Employee employee = null;

        HttpSession session = req.getSession();

        for (Employee e: employees
        ) {
            if (e.getUsername().equals(username)&&e.getPassword().equals(password))
            {
                req.getRequestDispatcher("navbarEmployee.html").include(req,resp);
                session.setAttribute("uname",username);
                session.setAttribute("id",e.getId());
                printWriter.println("You've successfully logged in!");
                employee = e;
                e.setLogged(true);
                employeeDao.updateEmployee(e);
            }
        }
        if (employee==null) {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/loginEmployee.html");
            requestDispatcher.include(req, resp);
            printWriter.println("Your credentials are incorrect!");
        }
        printWriter.close();


    }
}
