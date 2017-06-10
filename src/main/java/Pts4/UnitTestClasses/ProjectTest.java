package Pts4.UnitTestClasses;

import Pts4.Classes.Person;
import Pts4.Classes.Project;
import Pts4.Database.dbProject;
import Pts4.Enums.Function;
import com.sun.istack.internal.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Gebruiker on 10-4-2017.
 */
public class ProjectTest {

    @Test
    public void ProjectGetTest() throws Exception
    {
        dbProject.GetTop();
        Assert.assertFalse(dbProject.GetTop().equals(null));
    }

    @Test
    public void ProjectGetTest2() throws Exception
    {
        dbProject.GetTheRest();
        Assert.assertFalse(dbProject.GetTop().equals(null));
    }

    @Test
    public void GetTheMostLikelyTest() throws Exception
    {
        Person person = new Person(12345, "Jan", Function.Werknemer);

        ArrayList<Project> list = dbProject.GetTopMostLikely(person);

        Assert.assertNotEquals(list.size(), 0);
    }
}
