package Pts4.Database;

import Pts4.Classes.Project;

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


}
