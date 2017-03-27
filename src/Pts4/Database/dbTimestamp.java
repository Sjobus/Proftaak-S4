package Pts4.Database;

import Pts4.Classes.Timestamp;

import java.sql.*;

import static Pts4.Database.DatabaseConnection.disconnect;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class dbTimestamp {

    public static boolean InsertTimestamp(Timestamp t)
    {
        try {
            Connection con = DatabaseConnection.connect();

            String command = "{call InsertTimestamp(?,?,?,?)}";
            CallableStatement cstmt = con.prepareCall(command);
            //cstmt.registerOutParameter(2, Types.DECIMAL);

            //Date converter
            java.util.Date date = t.GetDate();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            cstmt.setDate(1, sqlDate);
            cstmt.setInt(2, t.GetHour());
            cstmt.setInt(3, t.Getperson().GetID());
            cstmt.setString(4, t.Getproject().GetID());

            //cstmt.setDate(1, now);
            cstmt.execute();
            //Double str = cstmt.getDouble(2);
            cstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            disconnect();
        }
    }
}
