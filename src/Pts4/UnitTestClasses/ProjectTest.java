package Pts4.UnitTestClasses;

import Pts4.Classes.staticPerson;
import Pts4.Database.dbProject;
import Pts4.Enums.Function;
import org.junit.Assert;
import org.junit.Test;

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
}
