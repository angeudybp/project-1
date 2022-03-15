package Servlets;

import Hibernate.Manager;
import Hibernate.ManagerDao;
import Hibernate.ManagerDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        int id = (Integer)session.getAttribute("id");
        ManagerDao managerDao = new ManagerDaoImp();
        Manager manager = managerDao.getManagerById(id);

        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">" +
                "</head>\n" +
                "<body class='bg-secondary'>\n" +
                " <div class=\"jumbotron jumbotron-fluid\">\n" +
                "  <div class=\"container\">\n" +
                "    <h1 class=\"display-4 text-dark\">Welcome "+manager.getName()+"</h1>\n" +
                "    <p class=\"lead text-dark\">Welcome to the homepage.</p>\n" +
                "  </div>\n" +
                "</div>" +
                "\n" +
                "</body>\n" +
                "</html>");


        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
