package dao;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

public class UsersDao{

    public void getConnection() throws SQLException, IOException {

        Properties prop = new Properties();
        File file = new File("C:\\Users\\Nameless\\IdeaProjects\\Web-tomcat\\src\\resources\\data.properties");
        FileInputStream in = new FileInputStream(file);
        if (in == null) {
            System.out.println("File read error");
        } else {
            System.out.println("Access allowed to the database");
            prop.load(in);
            in.close();
        }

        String database = prop.getProperty("database");
        String serverName = prop.getProperty("serverName");
        String port = prop.getProperty("port");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String driver = prop.getProperty("driver");


        System.out.println("DATABASE= "  +database);

    }
}
