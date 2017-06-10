package Pts4.UnitTestClasses;

import Pts4.Classes.Person;
// import Pts4.Classes.staticPerson;
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
        Person p = new Person();
        p.GetPersonData("Jan", "Jan123");
        Assert.assertTrue(p != null);

        String name = p.GetName();
        Assert.assertTrue(name.equals("Jan"));

        int ID = p.GetID();
        Assert.assertEquals(ID, 12345);

        Function Function = p.GetFunction();
        Assert.assertTrue(Function.equals(Function.Werknemer));
    }

}
