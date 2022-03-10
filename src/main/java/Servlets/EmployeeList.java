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
import java.util.List;

public class EmployeeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        EmployeeDao employeeDao = new EmployeeDaoImp();

        List<Employee> list = employeeDao.getEmployees();


        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Employee List</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/list.css\">" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <a href='add.html'><input type='button' value='Add Employee'></a>" +
                "          <table>\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Id</th>\n" +
                "                <th>Name</th>\n" +
                "                <th>Email</th>\n" +
                "                <th>Gender</th>\n" +
                "                <th>Update/Delete</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n");

        for (Employee e: list
        ) {
            out.println("<tr>" +
                    "<td>"+e.getId()+"</td>\n" +
                    "<td>"+e.getName()+"</td>\n" +
                    "<td>"+e.getEmail()+"</td>\n" +
                    "<td>"+e.getGender()+"</td>\n" +
                    "<<td><a href=\"/project-1/Servlets.UpdateEmployee?id="+e.getId()+"\"><input type=\"button\" value=\"update\"></a>\n" +
                    "<a href=\"/project-1/Servlets.DeleteEmployee?id="+e.getId()+"\"><input type=\"button\" value=\"delete\"></a></td>\n" +
                    "</tr>");
        }
        out.println("</tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
