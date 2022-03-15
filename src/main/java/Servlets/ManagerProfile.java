package Servlets;

import Hibernate.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class ManagerProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        int id = (Integer)session.getAttribute("id");
        ManagerDao managerDao = new ManagerDaoImp();
        Manager manager = managerDao.getManagerById(id);

        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("<html lang=\"en\"><head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/profileE.css\">\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "</head>\n" +
                "<body class='bg-secondary'>\n" +
                "<div class=\"container rounded bg-light mt-5 mb-5\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-3 border-right\">\n" +
                "            <div class=\"d-flex flex-column align-items-center text-center p-3 py-5\"><img class=\"rounded-circle mt-5\" width=\"150px\" src=\"https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg\"><span class=\"font-weight-bold\">"+manager.getName()+"</span><span class=\"text-black-50\">"+manager.getEmail()+"</span><span> </span></div>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-5 border-right\">\n" +
                "            <div class=\"p-3 py-5\">\n" +
                "                <div class=\"d-flex justify-content-between align-items-center mb-3\">\n" +
                "                    <h4 class=\"text-right\">Profile Settings</h4>\n" +
                "                </div>\n" +
                "                <form action='Servlets.ManagerProfile' method='post'>\n" +
                "                    <div class=\"row mt-3\">\n" +
                "                        <div class=\"col-md-12\"><label class=\"labels\">Name</label><input type=\"text\" name='name' class=\"form-control\"  value='"+manager.getName()+"'></div>\n" +
                "                        <div class=\"col-md-12\"><label class=\"labels\">Email</label><input type=\"text\" name='email' class=\"form-control\" value='"+manager.getEmail()+"'></div>\n"
        );
        if (manager.getGender().equals("female")){
            out.println("                        <div class=\"col-md-12\">\n" +
                    "                            <label class=\"labels\">Gender: </label>\n" +
                    "                            <input type=\"checkbox\" name=\"male\" id=\"male\"> <label class=\"labels\" for=\"male\">Male</label>\n" +
                    "                            <input type=\"checkbox\" checked='true' name=\"female\" id=\"female\"> <label class=\"labels\" for=\"female\">Female</label><br>\n"
            );

        }else{
            out.println("                        <div class=\"col-md-12\">\n" +
                    "                            <label class=\"labels\">Gender: </label>\n" +
                    "                            <input type=\"checkbox\" checked='true' name=\"male\" id=\"male\"> <label class=\"labels\" for=\"male\">Male</label>\n" +
                    "                            <input type=\"checkbox\" name=\"female\" id=\"female\"> <label class=\"labels\" for=\"female\">Female</label><br>\n"
            );

        }

        out.println("                        </div>\n" +
                "                    </div>\n" +

                "\n" +
                "                <div class=\"mt-5 text-center\"><button class=\"btn btn-primary profile-button\" type=\"submit\">Save Profile</button></div>\n" +
                "            </div>\n" +
                "          </form>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n" +
                "</body>\n" +
                "</html>");


        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ManagerDao managerDao = new ManagerDaoImp();
        HttpSession session = req.getSession();

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
        int id = (Integer)session.getAttribute("id");
        Manager manager = managerDao.getManagerById(id);

        manager.setName(name);
        manager.setEmail(email);
        manager.setGender(gender);
        managerDao.updateManager(manager);
        req.getRequestDispatcher("navbarManager.html").include(req,resp);
        out.println("<p>Manager updated successfully!</p>");
        out.close();
    }
}
