package web;

import model.Book;
import dao.BookDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "creatDao")
public class UserControllerCRUD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        String bookTitle = req.getParameter("title");
        String bookAuthor = req.getParameter("author");
//        float bookPrice = Float.parseFloat(req.getParameter("price"));
        String bookPrice = req.getParameter("price");

        System.out.println("Book title "  +bookTitle);
        System.out.println("Book author "  +bookAuthor);
        System.out.println("Book price "  +bookPrice);

        try {
            if (bookTitle != " " & bookAuthor !=" ") {
                System.out.println("********************************************");
                Book book = new Book(bookTitle, bookAuthor,bookPrice);
                BookDao bookDao = new BookDao();
                bookDao.saveBook(book);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("BookList.jsp");
                requestDispatcher.forward(req, resp);

            } else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("errorCreateUser.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (IOException | SQLException e) {
            System.out.println("Исключение выброшено UserControllerCRUD");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("errorCreateUser.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
