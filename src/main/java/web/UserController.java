package web;

import dao.DaoUser;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static dao.UsersDao.getConnection;

@WebServlet("/creatUser")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    private DaoUser userDao = DaoUser.getInstance();
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        System.out.println("Name " + " POST " + name);
        System.out.println("Password "+" POST " + password);
        System.out.println("Email " + " POST "+ email);
        System.out.println("_____________________________________________");

        try {
            if (name!="") {

                User user = new User(name, password,email);
                System.out.println("USER NAME " + user.getName());
                System.out.println("USER PASSWORD " + user.getPassword());
                System.out.println("USER EMAIL " + user.getEmail());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("aut.jsp");
                requestDispatcher.forward(request, response);


            } else {

                response.setContentType("text/html; charset=utf-8");

                PrintWriter out = response.getWriter();
                out.println("<h3> Вы вели значение.POST " + name + "</h3>");
                out.println("<h3> Вы вели значение.POST " + password + "</h3>");
                out.println("<h3> Вы вели значение.POST " + email + "</h3>");
            }

        }catch (IOException e){
            System.out.println("Исключение выброшено");
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        System.out.println("Name " + " GET " + name);
        System.out.println("Password " + " GET " + password);
        System.out.println("Email " + " GET " + email);

        try {
            if (name != "") {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("aut.jsp");
                requestDispatcher.forward(request, response);
            } else {

                response.setContentType("text/html; charset=utf-8");

                PrintWriter out = response.getWriter();
                out.println("<h3> Вы вели значение.GET " + name + "</h3>");
                out.println("<h3> Вы вели значение.GET " + password + "</h3>");
                out.println("<h3> Вы вели значение.GET " + email + "</h3>");
            }

        } catch (IOException e) {
            System.out.println("Исключение выброшено");
        }

    }

        protected void connection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {

                System.out.println("Connection to Store DB succesfull!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}