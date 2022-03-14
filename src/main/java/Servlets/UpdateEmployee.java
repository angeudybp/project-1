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

public class UpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeDao employeeDao = new EmployeeDaoImp();
        Employee employee = employeeDao.getEmployeeById(id);

        req.getRequestDispatcher("navbarManager.html").include(req,resp);

        printWriter.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Update Hibernate.Employee</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/add.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <h1>Update Employee</h1>\n" +
                "        <form action=\"Servlets.UpdateEmployee?id="+id+"\" method=\"post\">\n" +
                "            <label for=\"name\">Name</label>\n" +
                "            <input type=\"text\" name=\"name\" id=\"name\" value='"+ employee.getName()+"'><br>\n" +
                "            <label for=\"email\">Email</label>\n" +
                "            <input type=\"text\" name=\"email\" id=\"email\" value='"+employee.getEmail()+"'><br>\n"
               );
        if (employee.getGender().equals("female")){
            printWriter.println("            <label for=\"male\">Gender:</label>\n" +
                    "            <input type=\"checkbox\" name=\"male\" id=\"male\"> <label for=\"male\">Male</label>\n" +
                    "            <input type=\"checkbox\" name=\"female\" id=\"female\"checked ='true'> <label for=\"female\">Female</label><br>\n");
        }else {
            printWriter.println("            <label for=\"male\">Gender:</label>\n" +
                    "            <input type=\"checkbox\" name=\"male\" id=\"male\"checked ='true'> <label for=\"male\">Male</label>\n" +
                    "            <input type=\"checkbox\" name=\"female\" id=\"female\"> <label for=\"female\">Female</label><br>\n");
        }
        printWriter.println( "            <input type=\"submit\" value=\"update\" class=\"btn\">\n" +
                "        </form>\n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        EmployeeDao employeeDao = new EmployeeDaoImp();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String isMale = req.getParameter("male");
        String isFemale = req.getParameter("female");
        String gender;
        if (Objects.equals(isFemale, "on"))
        {
            gender = "female";
        }else if (Objects.equals(isMale, "on")){
            gender = "male";
        }else {
            gender = "undefined";
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeDao.getEmployeeById(id);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setName(name);

        employeeDao.updateEmployee(employee);
        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("<p>Employee updated successfully!</p>");
        out.close();
    }
}
