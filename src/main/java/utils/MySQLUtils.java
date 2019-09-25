package utils;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class's purpose is to make it easier to connect to the MySQL database as it's something that we'll
 * be needing to do quite often.
 */

public class MySQLUtils {

    /*
    Declare the connection option outside of the if statement so we can call it outside of the if statement or in
    this case, return conn.
     */
    private Connection conn;

    public Connection connect() {
        if (conn == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();
                String USERNAME = "admin";
                dataSource.setUser(USERNAME);
                String PASSWORD = "nc8apCseJVtQc5l8d1Ifbc3NFNNp0qufyBB";
                dataSource.setPassword(PASSWORD);
                String DATABASE_URL = "database-1.cwwiwjxwtcnh.us-west-2.rds.amazonaws.com";
                dataSource.setServerName(DATABASE_URL);
                dataSource.setPort(3306);
                dataSource.setDatabaseName("artemisdb");
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /*
    Here we declare the disconnect, the try-catch serves to make sure that if a error occurs it won't crash the bot but instead output to
    the console.
     */

    void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
