package Servlets;

import Hibernate.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReimbursementList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        EmployeeDao employeeDao = new EmployeeDaoImp();
        ReimbursementDao reimbursementDao = new ReimbursementDaoImp();

        List<Reimbursement> list = reimbursementDao.getReimbursement();


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
                "        <a href='/project-1/Servlets.FindReimbursement'><input type='button' value='Search Specific Employee'></a>" +
                "          <table>\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Employee</th>\n" +
                "                <th>Amount</th>\n" +
                "                <th>Status</th>\n" +
                "                <th>Approve/Deny</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n");

        for (Reimbursement e: list
        ) {
            out.println("<tr>" +
                    "<td>"+e.getEmployee().getName()+"</td>\n" +
                    "<td>"+e.getAmount()+"</td>\n" +
                    "<td>"+e.getStatus()+"</td>\n" +
                    "<<td><a href=\"/project-1/Servlets.ApproveReimbursement?id="+e.getTransactionId()+"\"><input type=\"button\" value=\"Approve\"></a>\n" +
                    "<a href=\"/project-1/Servlets.DenyReimbursement?id="+e.getTransactionId()+"\"><input type=\"button\" value=\"Deny\"></a></td>\n" +
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
