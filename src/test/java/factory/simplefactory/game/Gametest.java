package factory.simplefactory.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Gametest {

    @Test
    public void gameTest()
    {
        GameObject gameObject = Factory.getInstance(Gametype.BACK_GROUND);
        Assertions.assertNotNull(gameObject);
        Assertions.assertInstanceOf(BackgroundObject.class,gameObject);
    }

    @Test
    public void backGroundObjectTest(){
        GameObject gameObject = Factory.getInstance(Gametype.BACK_GROUND);
        Assertions.assertNotNull(gameObject);
        Assertions.assertTrue(gameObject instanceof BackgroundObject);
    }

    @Test
    public void foreGroundObjectTest() {
        GameObject gameObject = Factory.getInstance(Gametype.FORE_GROUND);
        Assertions.assertNotNull(gameObject);
        Assertions.assertTrue(gameObject instanceof ForegroundObject);
    }
}
