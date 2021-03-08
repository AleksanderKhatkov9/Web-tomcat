package dao;

import model.User;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;

import java.security.Permission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUser {

//    private static class SingletonHelper {
//        private static final DaoUser INSTANCE = new DaoUser();
//    }
//
//    public static DaoUser getInstance() {
//        return SingletonHelper.INSTANCE;
//    }
//
//


//    public static int saveUser(User user) throws SQLException {
//
//        System.out.println("DATA "  +user.getName());
//
//        String query = "INSERT INTO webdb.user" + " (id, user_name, password,email) VALUES " + " (?, ?, ?, ?);";
////        Connection conn = DataSourceFactory.getConnector();
////        PreparedStatement statement = conn.prepareStatement(query);
//        statement.setInt(1,user.getId());
//        statement.setString(2,user.getName());
//        statement.setString(3,user.getPassword());
//        statement.setString(4,user.getEmail());
//        int rows = statement.executeUpdate();
//        System.out.println("RESULT"  + rows);
//        return rows;
//    }
}
