package main.java.Pts4.UnitTestClasses;

import main.java.Pts4.Classes.Person;
import main.java.Pts4.Classes.Project;
import main.java.Pts4.Classes.Timestamp;
import main.java.Pts4.Database.DatabaseConnection;
import main.java.Pts4.Enums.Function;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Gebruiker on 26-3-2017.
 */
public class TimestampTest {


    @Test
    public void TimestampInsertTest() throws Exception
    {
        DatabaseConnection db = new DatabaseConnection();
        
        Date date = new Date(2017, 2, 16);
        Project pj = new Project("PTS41", "test");
        Person per = new Person(12345, "Jan", Function.Werknemer);

        Timestamp ts = new Timestamp(5, date, pj, per);

        Assert.assertTrue(ts.InsertTimestamp());
    }

    @Test
    public void TimestampFormanager() throws Exception
    {
        Project pr = new Project("PTS41", "test");
        Assert.assertFalse(Timestamp.GetAllTimestampsByProject(pr).equals(null));
    }
}
