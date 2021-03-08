package dao;

import model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UsersDao {

//    public static void main(String[] args) {
//        try {
////            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = getConnection()) {
//
//                System.out.println("Connection to Store DB succesfull!");
//            }
//        } catch (Exception ex) {
//            System.out.println("Connection failed...");
//
//            System.out.println(ex);
//        }
//    }



    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();

        FileInputStream in = new FileInputStream("database.properties");
        props.load(in);
        String database = props.getProperty("database");
        String serverName = props.getProperty("serverName");
        String port = props.getProperty("port");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        System.out.println("DATABASE " + database + " " + "SERVERNAME " + " " + serverName + " PORT " + port + " USER " + user + " " + "PASSWORD ");

        return DriverManager.getConnection(database, serverName, password);
    }
}
