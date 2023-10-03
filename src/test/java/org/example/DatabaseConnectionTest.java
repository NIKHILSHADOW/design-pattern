package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    @Test
    public void dbConnectionTest(){
        DatabaseConnection databaseConnection, databaseConnection1;
        databaseConnection = DatabaseConnection.getInstance();
        databaseConnection1= DatabaseConnection.getInstance();
        Assertions.assertEquals(databaseConnection,databaseConnection1,"both instances should be same");
    }
}
