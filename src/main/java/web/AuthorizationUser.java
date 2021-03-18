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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

@WebServlet(name ="authorUser")
public class AuthorizationUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String value1;
    private String value2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");

//        String val1 = getValue1();
//        String val2 = getValue2();
//
//        System.out.println("V1 " + val1);
//        System.out.println("V2 " + val2);


        try {
            if (!Objects.equals(userName, "")) {
                AutoUser autoUser = new AutoUser(userName, userPassword);

                UsersDao usersDao = new UsersDao();
                usersDao.validUser(autoUser);


            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("creatdao.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (IOException | SQLException e) {
            System.out.println("Исключение выброшено AuthorizationUser");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    public void doParam(List<String> res) {
        String name1Value = res.get(0);
        String name2Value = res.get(1);

        setValue1(name1Value);
        setValue2(name2Value);

        System.out.println("VALUE1 " + getValue1());
        System.out.println("VALUE2 " + getValue2());
    }
}