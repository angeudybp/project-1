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


public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeDao employeeDao = new EmployeeDaoImp();
        Employee employee = employeeDao.getEmployeeById(id);

        out.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Delete Hibernate.Employee</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/add.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"wrapper\">\n" +
                "    <h1>Delete Employee</h1>\n" +
                "    <form action='Servlets.DeleteEmployee?id="+id+"' method='post'>\n" +
                "        <p>Name:"+employee.getName()+"</p><br>\n" +
                "        <p>Email:"+employee.getEmail()+"</p><br>\n" +
                "        <p>Gender:"+employee.getGender()+"</p><br>\n" +
                "        <input type='submit' value='Delete' class='btn'><br>\n" +
                "    </form>\n" +
                "    <a href=\"/project-1/Servlets.EmployeeList\">View List</a>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        EmployeeDao employeeDao = new EmployeeDaoImp();

        int id = Integer.parseInt(req.getParameter("id"));


        employeeDao.deleteEmployee(id);
        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("Employee deleted successfully!");
        out.close();
    }
}
