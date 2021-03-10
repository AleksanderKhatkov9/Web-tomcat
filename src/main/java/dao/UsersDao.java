package dao;

import model.User;

import java.io.*;
import java.sql.*;
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

            System.out.println("Connection to Store DB succesfull!");
            String query = "SELECT * FROM webdb.user";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String user_name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String email = resultSet.getString(4);

//                System.out.println("ID= " + id + " NAME= " + user_name + " PASSWORD= " + pass + " EMAIL= " + email);
                connection = conn;

            }
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
        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();
//            System.out.println("**************************************************");
//        System.out.println("Connection to Store DB saveUser");
////        System.out.println("ID= " + id + " NAME= " + name + " PASSWORD= " + password + " EMAIL= " + email);
//            System.out.println("**************************************************");
//            System.out.println("FUNCTION == " + getUserPassword());

            Connection conn;
            Class.forName(getUserDriver());
            conn = DriverManager.getConnection(getUserUrl(), getUserDb(), getUserPassword());


            String query = "INSERT INTO webdb.user" + " (id,user_name, password, email) VALUES " + " (?, ?, ?, ?);";
//            String sql = "INSERT into stuff (name, description, quantity, location VALUES (?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, user.getId());
            statement.setString(1, name);
            statement.setString(3, password);
            statement.setString(4,email);
//            statement.executeUpdate(query);

            System.out.println(statement);
            conn.close();


        } catch (ClassNotFoundException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
