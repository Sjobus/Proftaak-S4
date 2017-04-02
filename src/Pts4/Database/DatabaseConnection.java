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

    private static Connection connection;
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
                 Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@fhictora01.fhict.local:1521:fhictora", "dbi331842", "Qwerty123");
            //jdbc:oracle:thin:@fhictora01.fhict.local:1521:fhictora

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
