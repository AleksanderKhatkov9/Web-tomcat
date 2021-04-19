package web;

import dao.BookIml;
import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "creatDao", urlPatterns = {"/s"})
public class DaoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        String bookTitle = req.getParameter("title");
        String bookAuthor = req.getParameter("author");
//      float bookPrice = Float.parseFloat(req.getParameter("price"));
        String bookPrice = req.getParameter("price");

        System.out.println("Book title " + bookTitle);
        System.out.println("Book author " + bookAuthor);
        System.out.println("Book price " + bookPrice);

        try {
            if (bookTitle != " " & bookAuthor != " ") {
                System.out.println("********************************************");
//                Book book = new Book(bookTitle, bookAuthor, bookPrice);
//                BookIml bookIml = new BookIml();
////                bookIml.save(book);

                  saveBook(req, resp);
//                listBook(req,resp);
//                updateBook(req,resp);
//                deleteBook(req,resp);


//                RequestDispatcher dispatcher = req.getRequestDispatcher("BookList.jsp");
//                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("errorCreateUser.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (IOException | SQLException e) {
            System.out.println("Исключение выброшено UserControllerDAO");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("errorCreateUser.jsp");
            requestDispatcher.forward(req, resp);
        }
    }


    private void saveBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        BookIml bookIml = new BookIml();
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        Book newBook = new Book(title, author, price);
        bookIml.save(newBook);
//        response.sendRedirect("listBook");
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request, response);
    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        BookIml bookIml = new BookIml();
        List<Book> listBook = bookIml.get();
        req.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = req.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        BookIml bookIml = new BookIml();
        int id = Integer.parseInt(request.getParameter("book.id"));
        bookIml.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
        dispatcher.forward(request, response);

    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        BookIml bookIml = new BookIml();
        int id = Integer.parseInt(request.getParameter("book.id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        Book upBook = new Book(id, title, author, price);
        bookIml.update(upBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        BookIml bookIml = new BookIml();
        int id = Integer.parseInt(request.getParameter("book.id"));
        bookIml.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request, response);
    }
}
