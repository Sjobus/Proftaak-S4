package Test.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;


/**
 * Created by Gebruiker on 20-3-2017.
 */
public class DatabaseConnection {
    String user = "root";
    String pass = "root";

    private Connection connection;
    private Properties properties;

    //Create properties

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", pass);
        }
        return properties;
    }

    //connect database
    public static Connection connect() {
        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//fhictora01.fhict.local:1521/fhictora", "dbi331842", "Qwerty123");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
