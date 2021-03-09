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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;



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
        System.out.println("Password " + " POST " + password);
        System.out.println("Email " + " POST " + email);
        System.out.println("_____________________________________________");

        try {
            if (name != "") {
                User user = new User(name, password, email);
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

        } catch (IOException e) {
            System.out.println("Исключение выброшено");
        }
    }


//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//
//        System.out.println("Name " + " GET " + name);
//        System.out.println("Password " + " GET " + password);
//        System.out.println("Email " + " GET " + email);
//
//        try {
//            if (name != "") {
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("aut.jsp");
//                requestDispatcher.forward(request, response);
//            } else {
//
//                response.setContentType("text/html; charset=utf-8");
//
//                PrintWriter out = response.getWriter();
//                out.println("<h3> Вы вели значение.GET " + name + "</h3>");
//                out.println("<h3> Вы вели значение.GET " + password + "</h3>");
//                out.println("<h3> Вы вели значение.GET " + email + "</h3>");
//            }
//
//        } catch (IOException e) {
//            System.out.println("Исключение выброшено");
//        }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        response.setContentType("text/html; charset=utf-8");
//        Properties prop = new Properties();
//        PrintWriter out = response.getWriter();
//
//        File file = new File("C:\\Users\\Nameless\\IdeaProjects\\Web-tomcat\\src\\resources\\data.properties");
//        FileInputStream in = new FileInputStream(file);
//        if (in == null) {
//            out.println("<h2>File read error </h2>");
//        } else {
//            out.println("<h2>Access allowed to the database</h2>");
//            prop.load(in);
//            in.close();
//        }
///
//        String database = prop.getProperty("database");
//        String serverName = prop.getProperty("serverName");
//        String port = prop.getProperty("port");
//        String user = prop.getProperty("user");
//        String password = prop.getProperty("password");
//        String driver = prop.getProperty("driver");
//
//            out.println("<h2>Вы получили значение.GET-DATABASE:" + " "+database+"</h2>");
//            out.println("<h2>Вы получили значение.GET-serverName:" + " "+serverName+"</h2>");
//            out.println("<h2>Вы получили значение.GET-port:" + " "+port+"</h2>");
//            out.println("<h2>Вы получили значение.GET-user:" + " "+user+"</h2>");
//            out.println("<h2>Вы получили значение.GET-password:" + " "+password+"</h2>");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        UsersDao usersDao = new UsersDao();
        try {
            usersDao.getConnection();
            out.println("<h2>Connection</h2>");

        } catch (SQLException throwables) {
            out.println("<h2>Error Connection </h2>");
            throwables.printStackTrace();
        }
    }
}