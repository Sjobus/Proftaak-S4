package Pts4.UnitTestClass;

import Test.Database.DatabaseConnection;
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
        Assert.assertTrue(DatabaseConnection.connect().equals(null));
    }


}
