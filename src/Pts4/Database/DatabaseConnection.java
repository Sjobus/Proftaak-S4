package Pts4.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


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
            return DriverManager.getConnection("jdbc:oracle://fhictora01.fhict.local/dbi331842?autoReconnect=true&useSSL=false&useUnicode=true", "dbi331842", "Qwerty123");

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
