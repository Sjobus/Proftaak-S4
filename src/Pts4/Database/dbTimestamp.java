package Pts4.Database;

import Pts4.Classes.Project;
import Pts4.Classes.Timestamp;
import Pts4.Classes.Person;

import java.sql.*;
import java.util.ArrayList;

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

            java.util.Date utilDate = t.GetDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

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

    public static ArrayList<Timestamp> GetTimeStampFromPerson(Person person)
    {
        ArrayList<Timestamp> list = new ArrayList<>();
        String personID = String.valueOf(person.GetID());

        try {
            String sql = "select * from tbhours t\n" +
                    "join tbperson p on t.PersonID = p.?\n" +
                    "join tbproject pr on pr.ID = t.PROJECTID;";
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setString(1, personID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String projectID = resultSet.getString("ID_2");
                int hours = resultSet.getInt("Hours");
                Date date = resultSet.getDate("DateWorked");
                String Description = resultSet.getString("Description");

                Project project = new Project(projectID, Description);
                Timestamp timestamp = new Timestamp(ID, hours, date, project);
                list.add(timestamp);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            disconnect();
        }

        return list;
    }
}
