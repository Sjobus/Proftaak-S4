package Pts4.Database;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Classes.staticPerson;
import Pts4.Enums.Function;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
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
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
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
}
