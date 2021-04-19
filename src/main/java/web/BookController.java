package web;

import model.Book;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "creatDao")
//public class BookController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private BookDao bookDao;
//
//
//    public void init(){
//        try {
//            bookDao.getConnBook();
//
//        } catch (Exception ex) {
//            System.out.println("Connection failed...");
//            System.out.println(ex);
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF8");
//        String bookTitle = req.getParameter("title");
//        String bookAuthor = req.getParameter("author");
////        float bookPrice = Float.parseFloat(req.getParameter("price"));
//        String bookPrice = req.getParameter("price");
//
//        System.out.println("Book title " + bookTitle);
//        System.out.println("Book author " + bookAuthor);
//        System.out.println("Book price " + bookPrice);
//
//
//        try {
//            if (bookTitle != " " & bookAuthor != " ") {
//                System.out.println("********************************************");
//                Book book = new Book(bookTitle, bookAuthor, bookPrice);
//                BookDao bookDao = new BookDao();
//                bookDao.saveBook(book);
//
//
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("BookList.jsp");
//                requestDispatcher.forward(req, resp);
//
//            } else {
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("errorCreateUser.jsp");
//                requestDispatcher.forward(req, resp);
//            }
//        } catch (IOException | SQLException e) {
//            System.out.println("Исключение выброшено UserControllerCRUD");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("errorCreateUser.jsp");
//            requestDispatcher.forward(req, resp);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////
////        Book book = new Book(x1, x2, x3);
////        BookDao bookDao = new BookDao();
////        bookDao.listAllBooks(book);
//
//        req.setAttribute("name", "Tom");
//        req.setAttribute("age", 34);
//        getServletContext().getRequestDispatcher("BookList.jsp").forward(req, resp);
//
//
//
//
//
////        String action = req.getServletPath();
////
////        try {
////            switch (action) {
////                case "/new":
////                    showNewForm(req, resp);
////                    break;
////                case "/insert":
////                    saveBook(req, resp);
////                    break;
////                case "/delete":
////                    deleteBook(req, resp);
////                    break;
////                case "/edit":
////                    showEditForm(req, resp);
////                    break;
////                case "/update":
////                    updateBook(req, resp);
////                    break;
////                default:
////                    listBook(req, resp);
////                    break;
////            }
////        } catch (SQLException ex) {
////            throw new ServletException(ex);
////        }
//    }
//
//
//    private void listBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
//        BookDao bookDao = new BookDao();
//        List<Book> listBook = bookDao.listAllBooks();
//        req.setAttribute("listBook", listBook);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("BookList.jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        BookDao bookDao = new BookDao();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Book existingBook = bookDao.getBook(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
//        request.setAttribute("book", existingBook);
//        dispatcher.forward(request, response);
//    }
//
//
//    private void saveBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        BookDao bookDao = new BookDao();
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String price = request.getParameter("price");
//
//        Book newBook = new Book(title, author, price);
//        bookDao.saveBook(newBook);
//        response.sendRedirect("list");
//    }
//
//    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        BookDao bookDao = new BookDao();
//        int id = Integer.parseInt(request.getParameter("id"));
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String price = request.getParameter("price");
//
//        Book book = new Book(id, title, author, price);
//        bookDao.updateBook(book);
//        response.sendRedirect("list");
//    }
//
//    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        BookDao bookDao = new BookDao();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Book book = new Book(id);
//        bookDao.deleteBook(book);
//        response.sendRedirect("list");
//
//    }
//
//}
