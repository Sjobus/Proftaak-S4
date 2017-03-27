package Pts4.Database;

import Pts4.Classes.Person;
import Pts4.Classes.staticPerson;
import Pts4.Enums.Function;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Pts4.Database.DatabaseConnection.disconnect;

/**
 * Created by Gebruiker on 26-3-2017.
 */
public class dbPerson {

    public static Person GetpersonData(String Name)
    {
        String sql = "Select * From TBPerson Where Name = ?";
        try {
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setString(1, Name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                //String name = resultSet.getString("max");
                String Function = resultSet.getString("Function");

                Function Func = staticPerson.Translatefunction(Function);

                Person p = new Person(ID, Name, Func);
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            disconnect();
        }
        return null;

    }

    public static Boolean SetPersonData(Person person)
    {
        try{

            return true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        } finally {
            disconnect();
        }
    }
}
