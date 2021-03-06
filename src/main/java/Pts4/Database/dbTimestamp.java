package Pts4.Database;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Classes.ProjectBean;
import Pts4.Classes.Timestamp;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import static Pts4.Database.DatabaseConnection.connect;
import static Pts4.Database.DatabaseConnection.disconnect;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class dbTimestamp {

    public static boolean InsertTimestamp(Timestamp t)
    {
        try {
            Connection con = connect();

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
        } catch (Exception ex) {
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
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); //Last day of the week
        java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());

        try
        {
            String sql = "select t.ID, t.DATEWORKED, t.Hours, pr.ID as prID, pr.DESCRIPTION " +
                    "from tbhours t " +
                    "join tbperson p on t.PersonID = p.ID " +
                    "join tbproject pr on pr.ID = t.PROJECTID " +
                    "where p.ID = ? AND t.DATEWORKED BETWEEN ? - 35 AND ? ORDER BY t.DATEWORKED DESC";

            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setString(1, personID);
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setDate(3, sqlDate);
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
        catch (Exception ex) {
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
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setString(1, prProject.GetID());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int Hours = resultSet.getInt("Hours");
                int PersonID = resultSet.getInt("ID");

                Person person = dbPerson.GetpersonDataByID(PersonID);

                Timestamp ts = new Timestamp(Hours, person);
                List.add(ts);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            disconnect();
        }

        return  List;
    }


    public static HashMap<String, Integer> GetTotalHoursProjects() //moet aangepast worden
    {
        HashMap<String, Integer> projectHourMap = new HashMap<>();

        String sql = "SELECT H.PROJECTID, sum(H.HOURS) AS Hours FROM TBHOURS H GROUP BY H.PROJECTID";
        try
        {
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String project = resultSet.getString("ProjectID");
                int hours = resultSet.getInt("Hours");
                projectHourMap.put(project, hours);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
        finally
        {
            disconnect();
        }
        return  projectHourMap;
    }

    public static ArrayList<ProjectBean> GetHoursManager(String like)
    {
        String sql = "";
        if(like == "")
        {
            //do normal
            sql = "select Pr.ID AS projectID, P.NAME as Name, sum(HOURS) as hours " +
                    "from TBProject Pr " +
                    "Join TBHOURS H on Pr.ID = H.PROJECTID " +
                    "Join TBPERSON P on P.ID = H.PERSONID " +
                    "GROUP BY Pr.ID, P.NAME" +
                    " order BY Pr.ID";
        }
        else
        {
            //do search
            sql = "select Pr.ID AS projectID, P.NAME as Name, sum(HOURS) as hours " +
                    "from TBProject Pr " +
                    "Join TBHOURS H on Pr.ID = H.PROJECTID " +
                    "Join TBPERSON P on P.ID = H.PERSONID " +
                    "Where PR.ID LIKE ? " +
                    "GROUP BY Pr.ID, P.NAME" +
                    " order BY Pr.ID";
        }

        try
        {
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            if(like != "") {
                preparedStatement.setString(1, "%"+like+"%");
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<ProjectBean> projectBeanList = new ArrayList<>();
            ProjectBean prBean = null;

            while (resultSet.next())
            {
                String projectID = resultSet.getString("projectID");
                String name = resultSet.getString("Name");
                int hours = resultSet.getInt("hours");

                if(prBean == null || !prBean.getProjectID().equalsIgnoreCase(projectID))
                {
                    prBean = new ProjectBean(projectID);
                    projectBeanList.add(prBean);
                }
                prBean.addtoProjectHours(name, hours);
            }
            return projectBeanList;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            disconnect();
        }
        return null;
    }
}
