package dao;

import model.AutoUser;
import model.User;
import model.UserValue;
import web.AuthorizationUser;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class UsersDao {
    private Connection connection;
    private String userUrl;
    private String userDb;
    private String userPassword;
    private String userDriver;

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserDb() {
        return userDb;
    }

    public void setUserDb(String userDb) {
        this.userDb = userDb;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDriver() {
        return userDriver;
    }

    public void setUserDriver(String userDriver) {
        this.userDriver = userDriver;
    }

    public Connection getConn() throws SQLException, IOException, ClassNotFoundException {
        Properties prop = new Properties();
        File file = new File("C:\\Users\\Nameless\\IdeaProjects\\Web-tomcat\\src\\resources\\data.properties");
//        File file = new File( "//home//sasha//IdeaProjects//Web-tomcat//src//main//resources//data.properties");
//        File file = new File( "C:\\Users\\benda\\IdeaProjects\\Web-tomcat\\src\\main\\resources\\data.properties");
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

            setUserUrl(url);
            setUserDb(user);
            setUserPassword(password);
            setUserDriver(driver);

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return connection;
    }

    public void saveUser(User user) throws SQLException, IOException {
        try {
            getConn();
            int id = user.getId();
            id = 1;
            String name = user.getName();
            String password = user.getPassword();
            String email = user.getEmail();
            Connection conn;
            Class.forName(getUserDriver());
            conn = DriverManager.getConnection(getUserUrl(), getUserDb(), getUserPassword());
//            System.out.println("ID= " + id + " NAME= " + name + " PASSWORD= " + password + " EMAIL= " + email);
            String sql = "INSERT INTO webdb.book (id,user_name, password, email) Values (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, email);
            System.out.println(statement);
            int rows = statement.executeUpdate();
            System.out.printf("%d rows added", rows);
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
    }

    public List<String> validUser(AutoUser autoUser) throws SQLException, IOException {
        List<String> result = new ArrayList<>();
        try {
            getConn();
            String name = autoUser.getName();
            String password = autoUser.getPassword();
            System.out.println("AutoUser1 = " + name);
            System.out.println("AutoUser2 =  " + password);
            /*DATABASE query select*from */
            Connection conn;
            Class.forName(getUserDriver());
            conn = DriverManager.getConnection(getUserUrl(), getUserDb(), getUserPassword());
            System.out.println("NAME= " + name + " PASSWORD= " + password);
            System.out.println("Connection to Store DB successful!!!");
            String query = "SELECT * FROM webdb.user";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String user_name = resultSet.getString(2);
                String user_password = resultSet.getString(3);
//                System.out.println("UserName="+ user_name);
//                System.out.println("Password="+ user_password);
                result.add(user_name);
                result.add(user_password);
//                System.out.println("LIST " + result);

                validList(result); //function
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        return result;
    }

    public List<String> validList(List<String> result) {
        List<String> param = new ArrayList<>();
        String n = result.get(0);
        String p = result.get(1);
        param.add(n);
        param.add(p);
        paramValue(param);
        System.out.println("Name-Dao= " + param.get(0));
        System.out.println("Password-Dao = " + param.get(1));
        AuthorizationUser authorizationUser = new AuthorizationUser();
//        authorizationUser.doParam(param);
        return param;
    }

    public void paramValue (List<String> list){
        String v1 = list.get(0);
        String v2 = list.get(1);
        UserValue userValue = new UserValue(v1,v2);
        AuthorizationUser authorizationUser = new AuthorizationUser();
        authorizationUser.paramDao(userValue);
    }
}
