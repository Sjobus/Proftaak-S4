package Pts4.UnitTestClass;

import Pts4.Database.DatabaseConnection;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Gebruiker on 20-3-2017.
 */

public class DatabaseTest {

    @Test
    public void DatabaseConnectionTest() throws Exception
    {
        DatabaseConnection db = new DatabaseConnection();
        Assert.assertFalse(DatabaseConnection.connect().equals(null));
    }


}
