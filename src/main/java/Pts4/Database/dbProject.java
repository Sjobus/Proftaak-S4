package Pts4.Database;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Classes.staticPerson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Pts4.Database.DatabaseConnection.connect;
import static Pts4.Database.DatabaseConnection.disconnect;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class dbProject {

    public static ArrayList<Project> GetAllProjects()
    {
       ArrayList<Project> list = new ArrayList<>();

        try {
            String sql = "select * from Project";
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            //preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String Description = resultSet.getString("Description");

                Project p = new Project(ID, Description);
                list.add(p);
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

    public static Project GetprojectID(Project project)
    {
        String sql = "Select * From TBProject Where ID = ?";
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setString(1, project.GetID());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String ID = resultSet.getString("ID");
                String description = resultSet.getString("Description");

                Project pro = new Project(ID, description);
                return pro;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            disconnect();
        }
        return null;
    }

    public static ArrayList<Project> GetTop()
    {
        ArrayList<Project> list = new ArrayList<>();

        try {
            String sql = "Select PROJECTID from (Select H.PROJECTID, Max(H.DateWorked) AS something From TBHOURS H Join TBPerson P on H.PERSONID = P.ID Where P.ID = ? Group by H.PROJECTID Order BY something desc) WHERE rownum <= 3";
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setInt(1, staticPerson.GetID());
            //preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ProjectID = resultSet.getString("PROJECTID");
                Project p = new Project(ProjectID);
                list.add(p);
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

    public static ArrayList<Project> GetTheRest()
    {
        ArrayList<Project> list = new ArrayList<>();

        try {
            String sql = "SELECT H.PROJECTID From TBHOURS H Join TBPerson P on H.PERSONID = P.ID Where H.PROJECTID not in (Select PROJECTID from (Select H.PROJECTID, Max(H.DateWorked) AS something From TBHOURS H Join TBPerson P on H.PERSONID = P.ID Where P.ID = ? Group by H.PROJECTID Order BY something desc) WHERE rownum <= 3) group by H.ProjectID";
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setInt(1, staticPerson.GetID());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ProjectID = resultSet.getString("PROJECTID");
                Project p = new Project(ProjectID);
                list.add(p);
            }
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            disconnect();
        }
    }


    //nieuwe algoritme (nog geïmplementeerd worden)

    public static ArrayList<Project> GetTopMostLikely(Person person)
    {
        ArrayList<Project> list = new ArrayList<>();

        try {
            String sql = "Select ProjectID From(select ProjectID, count(ProjectID) as aantal, sum(Hours) as WorkedHours " +
                    "From TBHOURS H Join TBPerson P " +
                    "on H.PERSONID = P.ID " +
                    "Where TO_CHAR(H.DateWorked,'fmDay') = TO_CHAR(CURRENT_DATE,'fmDay') " +
                    "AND H.DateWorked >= CURRENT_DATE - 36 AND H.DateWorked < CURRENT_DATE - 1 " +
                    "And P.ID = ? Group by ProjectID " +
                    "Order BY aantal desc, WorkedHours desc) " +
                    "Where Rownum <= 3";
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setInt(1, person.GetID());
            //preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ProjectID = resultSet.getString("PROJECTID");
                Project p = new Project(ProjectID);
                list.add(p);
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

    public static ArrayList<Project> GetTheRestLikely(Person person)
    {
        ArrayList<Project> list = new ArrayList<>();

        try {
            String sql = "SELECT H.PROJECTID " +
                    "From TBHOURS H " +
                    "Join TBPerson P on H.PERSONID = P.ID " +
                    "Where H.PROJECTID not in (Select ProjectID " +
                                                "From(select ProjectID, count(ProjectID) as aantal, sum(Hours) as WorkedHours " +
                                                "From TBHOURS H Join TBPerson P on H.PERSONID = P.ID " +
                                                "Where TO_CHAR(H.DateWorked,'fmDay') = TO_CHAR(CURRENT_DATE,'fmDay') " +
                                                "AND H.DateWorked >= CURRENT_DATE - 36 AND H.DateWorked < CURRENT_DATE - 1 And P.ID = ? " +
                                                "Group by ProjectID Order BY aantal desc, WorkedHours desc) " +
                    "Where Rownum <= 3) " +
                    "group by H.ProjectID";
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setInt(1, person.GetID());
            //preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ProjectID = resultSet.getString("PROJECTID");
                Project p = new Project(ProjectID);
                list.add(p);
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

    public static Project GetMostLikely(Person person)
    {

        try {
            String sql = "Select ProjectID " +
                    "From(select ProjectID, count(ProjectID) as aantal, sum(Hours) as WorkedHours " +
                            "From TBHOURS H Join TBPerson P on H.PERSONID = P.ID " +
                            "Where TO_CHAR(H.DateWorked,'fmDay') = TO_CHAR(CURRENT_DATE,'fmDay') " +
                            "AND H.DateWorked >= CURRENT_DATE - 36 AND H.DateWorked < CURRENT_DATE - 1 " +
                            "And P.ID = ? Group by ProjectID Order BY aantal desc, WorkedHours desc) " +
                            "Where Rownum <= 1";
            PreparedStatement preparedStatement = connect().prepareStatement(sql);
            preparedStatement.setInt(1, person.GetID());
            //preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ProjectID = resultSet.getString("PROJECTID");
                Project p = new Project(ProjectID);
                return p;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            disconnect();
        }
        return null;
    }
}
