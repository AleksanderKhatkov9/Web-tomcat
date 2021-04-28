package dao;

import model.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookIml implements BookDAO {
    public Connection connection;
    public String bookUrl;
    public String bookDb;
    public String bookPassword;
    public String bookDriver;

    @Override
    public Connection getConnBook() throws SQLException, IOException, ClassNotFoundException {
        Properties prop = new Properties();
        File file = new File("//home//sasha//IdeaProjects//Web-tomcat//src//main//resources//data.properties");
//        File file = new File("C://Users//ipoli//IdeaProjects//Web-tomcat//src//main//resources//data.properties");
        FileInputStream in = new FileInputStream(file);
        if (in == null) {
            System.out.println("File read error");
        } else {
            System.out.println("Access allowed to the database");
            prop.load(in);
            in.close();
        }
        try {
            Connection conn;
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            String driver = prop.getProperty("driver");

            bookUrl = url;
            bookDb = user;
            bookPassword = password;
            bookDriver = driver;

            System.out.println(bookUrl);

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return connection;
    }

    @Override
    public List<Book> get() {
        ArrayList<Book> listBook = new ArrayList<>();
        try {
            getConnBook();
            Connection conn;
            Class.forName(bookDriver);
            conn = DriverManager.getConnection(bookUrl, bookDb, bookPassword);
            String sql = "SELECT * FROM webdb.book";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String price = resultSet.getString("price");
                Book book = new Book(id, title, author, price);
                System.out.println("Book= " + "id = " +  book.getId() + " title=" + book.getTitle()+ " author= " +  book.getAuthor() + " price = " + book.getPrice());
                listBook.add(book);
                System.out.println(book);
            }

        } catch (ClassNotFoundException | IOException | SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        return listBook;
    }

    @Override
    public Book get(int id) {
        Book book = null;
        String sql = "SELECT * FROM webdb.book WHERE id = ?";
        try {
            getConnBook();
            Connection conn;
            Class.forName(bookDriver);
            conn = DriverManager.getConnection(bookUrl, bookDb, bookPassword);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String price = resultSet.getString("price");
                book = new Book(id, title, author, price);
                System.out.println("EDIT " + book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean save(Book book) throws IOException, SQLException {
        boolean flag = false;
        try {
            getConnBook();
            int id = book.getId();
            String title = book.getTitle();
            String author = book.getAuthor();
            String price = book.getPrice();
            Connection conn;
            Class.forName(bookDriver);
            conn = DriverManager.getConnection(bookUrl, bookDb, bookPassword);
            String sql = "INSERT INTO webdb.book (id, title, author, price) Values (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.setString(4, price);
            System.out.println(statement);
            int rows = statement.executeUpdate();
            System.out.printf("%d rows added", rows);
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        return flag;
    }


    @Override
    public boolean update(Book book) {
        boolean flag = false;
        try {
            getConnBook();
            Connection conn;
            Class.forName(bookDriver);
            conn = DriverManager.getConnection(bookUrl, bookDb, bookPassword);
            String sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPrice());
            statement.setInt(4, book.getId());
            System.out.println(statement);
            int rows = statement.executeUpdate();
            System.out.printf("%d rows added", rows);
            conn.close();
        } catch (ClassNotFoundException | IOException | SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        return flag;
    }


    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            getConnBook();
            Connection conn;
            Class.forName(bookDriver);
            conn = DriverManager.getConnection(bookUrl, bookDb, bookPassword);
            String sql = "DELETE FROM book where id =" + id;
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(statement);
            int rows = statement.executeUpdate();
            System.out.printf("%d rows added", rows);
            flag = true;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        return flag;
    }
}
