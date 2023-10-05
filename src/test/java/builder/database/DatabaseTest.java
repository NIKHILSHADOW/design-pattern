package builder.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    @Test
    public void dbBuilderTest(){
        Database.DatabaseBuilder databaseBuilder = Database.DatabaseBuilder.toBuilder();
        Assertions.assertNotNull(databaseBuilder,"Object should be created");
    }
    @Test
    public void dbTest() {
        Database.DatabaseBuilder databaseBuilder = Database.DatabaseBuilder.toBuilder();
        try{
            Database database = databaseBuilder
                    .withName("test")
                    .withHost("p")
                    .withPort(8585)
                    .withPassword("pass")
                    .build();
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
