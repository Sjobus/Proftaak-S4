package Pts4.UnitTestClasses;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Classes.Timestamp;
import Pts4.Database.DatabaseConnection;
import Pts4.Enums.Function;
import org.junit.Assert;
import org.junit.Test;
import sun.util.calendar.BaseCalendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Gebruiker on 26-3-2017.
 */
public class TimestampTest {


    @Test
    public void TimestampInsertTest() throws Exception
    {
        DatabaseConnection db = new DatabaseConnection();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2017);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        cal.set(Calendar.DAY_OF_MONTH, 16);
        Date date = cal.getTime();

        //Date date = new Date(2017 - 1900, 2, 16);

        Project pj = new Project("PTS41", "test");
        Person per = new Person(12345, "Jan", Function.Werknemer);

        Timestamp ts = new Timestamp(5, date, pj, per);

        Assert.assertTrue(ts.InsertTimestamp());
    }
}
