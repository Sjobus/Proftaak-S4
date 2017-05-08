package Pts4.UnitTestClasses;

import Pts4.Classes.staticPerson;
import Pts4.Enums.Function;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Gebruiker on 20-3-2017.
 */

//test
public class PersonTest {

    @Test
    public void PersonGetTest() throws Exception
    {
        Assert.assertTrue(staticPerson.GetPersonData("Jan", "Jan123"));

        String name = staticPerson.GetName();
        Assert.assertTrue(name.equals("Jan"));

        int ID = staticPerson.GetID();
        Assert.assertEquals(ID, 12345);

        Function Function = staticPerson.GetFunction();
        Assert.assertTrue(Function.equals(Function.Werknemer));
    }

}
