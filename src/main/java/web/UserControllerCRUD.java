package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "creatdao")
public class UserControllerCRUD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        String bookTitle = req.getParameter("title");
        String bookAuthor = req.getParameter("author");
        float bookPrice = Float.parseFloat(req.getParameter("price"));

        System.out.println("Book title "  +bookTitle);
        System.out.println("Book author "  +bookAuthor);
        System.out.println("Book price "  +bookPrice);

    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
