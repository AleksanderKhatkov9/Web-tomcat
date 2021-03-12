package web;

import dao.DaoUser;
import dao.UsersDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;



@WebServlet("/creatUser")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

//        System.out.println("Name " + " POST " + name);
//        System.out.println("Password " + " POST " + password);
//        System.out.println("Email " + " POST " + email);

        try {
            if (name != "") {
//                System.out.println("********************************************");
                User user = new User(name, password, email);
//                System.out.println("USER NAME " + user.getName());
//                System.out.println("USER PASSWORD " + user.getPassword());
//                System.out.println("USER EMAIL " + user.getEmail());
//                System.out.println("********************************************");

                UsersDao usersDao = new UsersDao();
                usersDao.saveUser(user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("aut.jsp");
                requestDispatcher.forward(request, response);



            } else {
//                response.setContentType("text/html; charset=utf-8");
//
//                PrintWriter out = response.getWriter();
//                out.println("<h3> Вы вели значение.POST " + name + "</h3>");
//                out.println("<h3> Вы вели значение.POST " + password + "</h3>");
//                out.println("<h3> Вы вели значение.POST " + email + "</h3>");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("errorCreateUser.jsp");
                requestDispatcher.forward(request, response);

            }

        } catch (IOException | SQLException e) {
            System.out.println("Исключение выброшено UserController");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
                response.setContentType("text/html; charset=utf-8");

                PrintWriter out = response.getWriter();
                out.println("<h3> Был запущен СreatUser </h3>");
//                out.println("<h3> Вы вели значение.GET " + password + "</h3>");
//                out.println("<h3> Вы вели значение.GET " + email + "</h3>");
            }


}