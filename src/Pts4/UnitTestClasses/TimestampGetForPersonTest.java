package Pts4.UnitTestClasses;

import Pts4.Classes.*;
import Pts4.Database.*;
import Pts4.Enums.Function;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.ArrayList;

public class TimestampGetForPersonTest {

    @Test
    public void TimestampGetTest() throws Exception
    {
        DatabaseConnection db = new DatabaseConnection();
        dbTimestamp dbTimestamp = new dbTimestamp();
        Person person = new Person(12345,"Henk", Function.Werknemer);

        ArrayList<Timestamp> arraylist = dbTimestamp.GetTimeStampForPerson(person);
        System.out.println("Getting stuff");
        System.out.println("Size of list: " + arraylist.size());

        for (Timestamp timestamp : arraylist) {
            System.out.println(timestamp.GetID());
        }

        if (arraylist.size() > 2)
        {
            boolean bool = false;
           Assert.assertFalse(bool);
        }

        else {
            boolean bool = true;
            Assert.assertFalse(bool);
        }

    }
}
