package web;

import dao.UsersDao;
import model.AutoUser;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

@WebServlet("/authorUser")
public class AuthorizationUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String userName = request.getParameter("n");
        String userPassword = request.getParameter("p");

        System.out.println("Name " + " POST " + userName);
        System.out.println("Password " + " POST " + userPassword);

        try {
            if (!Objects.equals(userName, "")) {

                AutoUser autoUser = new AutoUser(userName,userPassword);
                System.out.println("********************************************");
                System.out.println("USER NAME " + autoUser.getName());
                System.out.println("USER PASSWORD " + autoUser.getPassword());
                System.out.println("********************************************");

                UsersDao usersDao = new UsersDao();
                usersDao.validUser(autoUser);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("creatdao.jsp");
                requestDispatcher.forward(request, response);

            } else {
                response.setContentType("text/html; charset=utf-8");

                PrintWriter out = response.getWriter();
                out.println("<h3> Вы вели значение.POST  " + userName + "</h3>");
                out.println("<h3> Вы вели значение.POST " + userPassword + "</h3>");
            }
        } catch (IOException | SQLException e) {
            System.out.println("Исключение выброшено");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<h3> Был запущен AuthorUser </h3>");



    }
}