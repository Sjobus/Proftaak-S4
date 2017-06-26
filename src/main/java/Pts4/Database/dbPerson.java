package Pts4.Database;

import Pts4.Classes.Person;
// import Pts4.Classes.staticPerson;
import Pts4.Enums.Function;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Pts4.Database.DatabaseConnection.disconnect;

/**
 * Created by Gebruiker on 26-3-2017.
 */
public class dbPerson {

    public static Person GetpersonData(String Name, String Password)
    {
        String sql = "Select * From TBPerson Where Name = ? AND Password = ?";
        try {
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                //String name = resultSet.getString("max");
                String function = resultSet.getString("Function");

                Person p = new Person();
                Function Func = p.Translatefunction(function);

                p = new Person(ID, Name, Func);
                return p;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            disconnect();
        }
        return null;

    }

    public static Person GetpersonDataByID(int PersonID)
    {
        String sql = "Select * From TBPerson Where ID = ?";
        try {
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setInt(1, PersonID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String function = resultSet.getString("Function");

                Person p = new Person();
                Function Func = p.Translatefunction(function);

                 p = new Person(PersonID, name, Func);
                return p;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            disconnect();
        }
        return null;

    }

    public static Person GetpersonDataByGoogleID(String googleID)
    {
        String sql = "Select * From TBPerson Where GoogleID = ?";
        try {
            PreparedStatement preparedStatement = DatabaseConnection.connect().prepareStatement(sql);
            preparedStatement.setString(1, googleID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String function = resultSet.getString("Function");

                Person p = new Person();
                Function Func = p.Translatefunction(function);

                p = new Person(ID, name, Func);

                return p;
            }
        } catch (Exception ex) {
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
