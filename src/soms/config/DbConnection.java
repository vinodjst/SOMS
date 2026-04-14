package soms.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getDbConnection() throws SQLException {

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");//add the jar file OW will get runtime error - ClassNotFoundException
            // Establish connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/soms", "root", "root"
            );

            System.out.println("Connection - Established..");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection - Error connecting to Database");
        }finally {
         //   connection.close();
            System.out.println("Connection - Closed");
    }

    return  connection;

    }

}
