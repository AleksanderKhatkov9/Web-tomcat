package web;

import dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet("/h")
public class AuthorizationUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//
//        System.out.println("Name " + name);
//        System.out.println("Password " + password);
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        UsersDao usersDao = new UsersDao();
//        try {
//            usersDao.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//
//
//    }
}
