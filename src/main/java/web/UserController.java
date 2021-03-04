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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@WebServlet("/creatUser")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoUser userDao = DaoUser.getInstance();
//    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

//        request.setCharacterEncoding("UTF8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//
//        System.out.println("Name " + name);
//        System.out.println("Password " + password);
//        System.out.println("Email " + email);


//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/aut.jsp");
//            requestDispatcher.forward(request, response);
//            request.getRequestDispatcher("jsp/aut.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("jsp/check.jsp"); // start jsp page check.jsp
        response.sendRedirect("jsp/index.jsp"); // start jsp page check.jsp

        request.setCharacterEncoding("UTF8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if(name!=null){
            response.sendRedirect("jsp/aut.jsp"); // start jsp page check.jsp
        }

    }
}