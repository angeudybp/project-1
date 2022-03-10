package Servlets;

import Hibernate.Reimbursement;
import Hibernate.ReimbursementDao;
import Hibernate.ReimbursementDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DenyReimbursement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        ReimbursementDao reimbursementDao = new ReimbursementDaoImp();
        Reimbursement reimbursement = reimbursementDao.getReimbursementById(id);

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
                "    <h1>Approve Reimbursement</h1>\n" +
                "    <form action='Servlets.DenyReimbursement?id="+id+"' method='post'>\n" +
                "        <p>Name:"+reimbursement.getEmployee().getName()+"</p><br>\n" +
                "        <p>Amount:"+reimbursement.getAmount()+"</p><br>\n" +
                "        <p>Status:"+reimbursement.getStatus()+"</p><br>\n" +
                "        <input type='submit' value='Deny' class='btn'><br>\n" +
                "    </form>\n" +
                "    <a href=\"/project-1/Servlets.ReimbursementList\">View List</a>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        ReimbursementDao reimbursementDao = new ReimbursementDaoImp();
        Reimbursement reimbursement = reimbursementDao.getReimbursementById(id);
        reimbursement.setStatus("Denied");
        reimbursementDao.updateReimbursement(reimbursement);
        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("Reimbursement Denied successfully!");
        out.close();
    }
}
