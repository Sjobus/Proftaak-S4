package Pts4.Database;

import Pts4.Classes.Project;
import Pts4.Classes.Timestamp;
import Pts4.Classes.Person;
import Pts4.Classes.staticPerson;
import Pts4.Enums.Function;

import java.sql.*;

import java.util.ArrayList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


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

            java.util.Date utilDate = new java.util.Date(t.GetDate().getTime());
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

    public static ArrayList<Timestamp> GetTimeStampForPerson(Person person)
    {
        ArrayList<Timestamp> list = new ArrayList<>();
        String personID = String.valueOf(person.GetID());
      //  int personid2 = person.GetID();

        try {
            String sql = "select t.ID, t.DATEWORKED, t.Hours, pr.ID as prID , pr.DESCRIPTION from tbhours t\n" +
                    "join tbperson p on t.PersonID = p.ID\n" +
                    "join tbproject pr on pr.ID = t.PROJECTID\n" +
                    "where p.ID = ? AND dateworked > sysdate - 35;";


            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setString(1, personID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String projectID = resultSet.getString("prID");
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

    public static ArrayList<Timestamp> GetTimeStampForManager(Project prProject)
    {
        ArrayList<Timestamp> List = new ArrayList();

        String sql = "Select P.NAME, P.ID AS ID, sum(H.HOURS) AS Hours From TBHOURS H Join TBPERSON P on H.PERSONID = P.ID Join TBPROJECT PJ on H.PROJECTID = PJ.ID Where PJ.ID = ? Group BY P.NAME, P.ID Order BY PJ.ID";
        try {
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setString(1, prProject.GetID());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int Hours = resultSet.getInt("Hours");
                int PersonID = resultSet.getInt("ID");

                Person person = dbPerson.GetpersonDataByID(PersonID);

                Timestamp ts = new Timestamp(Hours, person);
                List.add(ts);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            disconnect();
        }

        return  List;
    }


}
