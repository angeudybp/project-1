package Servlets;

import Hibernate.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeReimbursement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        PrintWriter out = resp.getWriter();

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
                "        <a href='addReimbursement.html'><input type='button' value='Add Reimbursement'></a>" +
                "          <table>\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Employee</th>\n" +
                "                <th>Amount</th>\n" +
                "                <th>Status</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n");

        for (Reimbursement e: list
        ) {
            if (e.getEmployee().getId()==id) {
                out.println("<tr>" +
                        "<td>" + e.getEmployee().getName() + "</td>\n" +
                        "<td>" + e.getStatus() + "</td>\n" +
                        "<td>" + e.getAmount() + "</td>\n" +
                        "</tr>");
            }
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
