package web;

import dao.UsersDao;
import model.AutoUser;
import model.UserValue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "authorUser")
public class AuthorizationUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static String nameValue;
    public static String passwordValue;

    public static String getPostName;
    public static String getPostPassword;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");

        getPostName = userName;
        getPostPassword = userPassword;


        try {
//            endParam(request, response);
//            showNewForm(request, response, userName, userPassword);

            if (!userName.equals(" ")) {
                AutoUser autoUser = new AutoUser(userName, userPassword);
                UsersDao usersDao = new UsersDao();
                usersDao.validUser(autoUser);

                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("creatdao.jsp");
                requestDispatcher1.forward(request, response);

            } else {
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("error.jsp");
                requestDispatcher2.forward(request, response);
            }
        } catch (IOException | SQLException e) {
            System.out.println("Исключение выброшено AuthorizationUser");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


//
//    public List<String> doParam(List<String> res) {
//        List<String> resParam = new ArrayList<>();
//        String name1Value = res.get(0);
//        String namsetValue1e2Value = res.get(1);
////        (name1Value);
////        setValue2(name2Value);
//        resParam.add(name1Value);
//        resParam.add(name2Value);
////        System.out.println("VALUE1 " + resParam.get(0));
////        System.out.println("VALUE2 " +  resParam.get(1));
//        return resParam;
//    }


    public void paramDao(UserValue userValue) {
        List<String> listParam = new ArrayList<>();
        String valParam1 = userValue.getParamSqlName();
        String valParam2 = userValue.getParamSqlPassword();
//        System.out.println("paramDao T1 " + valParam1);
//        System.out.println("paramDao T2 " + valParam2);

        nameValue = valParam1;
        passwordValue =valParam2;

        listParam.add(valParam1);
        listParam.add(valParam2);
        funParam(listParam);
    }


    public List<String> funParam(List<String> param) {
        List<String> list = new ArrayList<>();
        String name = param.get(0);
        String password = param.get(1);
//        System.out.println("T1 " + name);
//        System.out.println("T2 " + password);
        list.add(name);
        list.add(password);

        endParam();
        return list;
    }

    public void showNewForm(HttpServletRequest req, HttpServletResponse resp, String name, String password) throws SQLException, IOException, ServletException {
        String nameFunc = name;
        String passwordFunc = password;
        System.out.println("NAME " + nameFunc);
        System.out.println("Password " + passwordFunc);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
//        requestDispatcher.forward(req, resp);
    }

    public void endParam(){
        String sName = nameValue;
        System.out.println("END-Name "  +sName);
        String sPassword = passwordValue;
        System.out.println("END-Password "  +sPassword);
        System.out.println("END-3 "  + getPostName);
        System.out.println("END-4 " + getPostPassword);
    }

}