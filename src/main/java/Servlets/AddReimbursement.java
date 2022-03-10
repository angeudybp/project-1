package Servlets;

import Hibernate.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class AddReimbursement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        double amount = Double.parseDouble(req.getParameter("amount"));
        HttpSession session = req.getSession();

        int id = (int) session.getAttribute("id");

        req.getRequestDispatcher("navbarEmployee.html").include(req,resp);

        ReimbursementDao reimbursementDao = new ReimbursementDaoImp();
        EmployeeDao employeeDao = new EmployeeDaoImp();
        Reimbursement reimbursement = new Reimbursement(amount,"pending",employeeDao.getEmployeeById(id));
        reimbursementDao.addReimbursement(reimbursement,id);
        out.println("Reimbursement added successfully!");
        out.close();


    }
}
