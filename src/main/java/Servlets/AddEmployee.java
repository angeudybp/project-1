package Servlets;

import Hibernate.Employee;
import Hibernate.EmployeeDao;
import Hibernate.EmployeeDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class AddEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        EmployeeDao employeeDao = new EmployeeDaoImp();
        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        req.getRequestDispatcher("add.html").include(req,resp);

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String isMale = req.getParameter("male");
        String isFemale = req.getParameter("female");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender;
        if (Objects.equals(isFemale, "on"))
        {
            gender = "female";
        }else if (Objects.equals(isMale, "on")){
            gender = "male";
        }else {
            gender = "undefined";
        }
        Employee employee = new Employee(name,email,gender,username,password,false);

        employeeDao.addEmployee(employee);



        out.print("Records Saved successfully!");
        out.close();
    }
}
