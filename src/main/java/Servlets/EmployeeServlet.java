package Servlets;

import Hibernate.Employee;
import Hibernate.EmployeeDao;
import Hibernate.EmployeeDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        int id = (Integer)session.getAttribute("id");
        EmployeeDao employeeDao = new EmployeeDaoImp();
        Employee employee = employeeDao.getEmployeeById(id);

        req.getRequestDispatcher("navbarEmployee.html").include(req,resp);
        out.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div>\n" +
                "        <h1>Welcome "+employee.getName()+"</h1>\n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");


        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
