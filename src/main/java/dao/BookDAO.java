package dao;

import model.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    Connection getConnBook() throws SQLException, IOException, ClassNotFoundException;
    List<Book> get();
    Book get(int id);
    boolean save(Book book) throws IOException, SQLException;
    boolean update(Book book);
    boolean delete(int id);
}
