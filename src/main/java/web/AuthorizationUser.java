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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
            showNewForm(request, response);

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

//        byte valPar1 = Byte.parseByte(userValue.getParamSqlName());
//        byte valPar2 = Byte.parseByte(userValue.getParamSqlName());


//        byte[] bytes1;
//        try {
//            bytes1 = valParam1.getBytes("UTF-8");
//            aByte = bytes1;
////            String text1 = new String(bytes1, "UTF-8");
////            System.out.println("Byte " + text1);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        nameValue = valParam1;
        passwordValue = valParam2;



        String doParam = endParam();
        System.out.println("Post " + doParam);


        listParam.add(valParam1);
        listParam.add(valParam2);
        funParam(listParam);
    }

    public List<String> funParam(List<String> param) {
        List<String> list = new ArrayList<>();
        String name = param.get(0);
        String password = param.get(1);
        list.add(name);
        list.add(password);


        String doParam = endParam();
        System.out.println("Post " + doParam);

        return list;
    }


    public String endParam() {
        String resultParam;
        String sName = nameValue;
        String sPassword = passwordValue;
        String doPostName = getPostName;
        String doPostPassword = getPostPassword;
        System.out.println("nameValue: " + sName);
        System.out.println("passwordValue " + sPassword);
        System.out.println("getPostName " + doPostName);
        System.out.println("getPostPassword " + doPostPassword);

        if (sName.equals(doPostName) & sPassword.equals(doPostPassword)) {
            resultParam = "Yes";
//            System.out.println("Yes " +resultParam);
//            res = resultParam;
        } else {
            resultParam = "No";
//            System.out.println("No " + resultParam);
//            res = resultParam;
        }
        return resultParam;
    }


    public void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        req.setCharacterEncoding("UTF8");

//        byte[] bytes10;
//        bytes10 = aByte;
//        String text1 = new String(bytes10, "UTF-8");
//        System.out.println("Byte " + text1);

        PrintWriter out = resp.getWriter();
        out.println("<h3> AutoUser </h3>");
        out.println("<h3> Вы вели значение.GET  " + nameValue + "</h3>");
        out.println("<h3> Вы вели значение.GET " + passwordValue + "</h3>");

        System.out.println("Error-1 " + nameValue);
        System.out.println("Error2 " + passwordValue);


//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
//        requestDispatcher.forward(req, resp);
    }


}