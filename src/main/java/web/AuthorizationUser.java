package web;

import dao.UsersDao;
import model.AutoUser;
import model.User;
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

@WebServlet(name ="authorUser")
public class AuthorizationUser extends HttpServlet{
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




        setValue1(userName);

        f();

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

//
//    public List<String> doParam(List<String> res) {
//        List<String> resParam = new ArrayList<>();
//        String name1Value = res.get(0);
//        String name2Value = res.get(1);
////        setValue1(name1Value);
////        setValue2(name2Value);
//        resParam.add(name1Value);
//        resParam.add(name2Value);
////        System.out.println("VALUE1 " + resParam.get(0));
////        System.out.println("VALUE2 " +  resParam.get(1));
//        return resParam;
//    }



    public void fun(UserValue userValue){
        List<String> listParam = new ArrayList<>();
        String valParam1 = userValue.getParamSqlName();
        String valParam2 = userValue.getParamSqlPassword();
//        System.out.println("T1 " + valParam1);
//        System.out.println("T2 " + valParam2);
        listParam.add(valParam1);
        listParam.add(valParam2);
        funParam(listParam);

    }

    public List<String> funParam(List<String> param){
        List<String> list = new ArrayList<>();
        String name = param.get(0);
        setValue1(name);
        String password = param.get(1);
        setValue2(password);

//        System.out.println("T1 " + name);
//        System.out.println("T2 " + password);
        list.add(name);
        list.add(password);
        return list;
    }


    protected void f(){
        System.out.println("HHHHH " + getValue1());
    }

}