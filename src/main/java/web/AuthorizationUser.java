package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorUser")
public class AuthorizationUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        request.setCharacterEncoding("UTF8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        System.out.println("Name " + name);
        System.out.println("Password " + password);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        response.sendRedirect("jsp/aut.jsp"); // start jsp page check.jsp

    }
}
