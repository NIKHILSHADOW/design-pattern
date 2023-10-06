package prototype.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameRegistryTest {
    GameRegistry gameRegistry = new GameRegistry();
    BackgroundGameObject backgroundGameObject = new BackgroundGameObject(100,100,200,200,GameObjectType.BACK_GROUND);
    ForegroundGameObject foregroundGameObject = new ForegroundGameObject();

    @Test
    public void addBackgroundObjectToRegistryTest() {
        try {
            gameRegistry.addPrototype(backgroundGameObject.getType(), backgroundGameObject);
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            return;
        }
    }

    @Test
    public void addforegroundObjectToRegistryTest() {
         try {
            gameRegistry.addPrototype(foregroundGameObject.getType(), foregroundGameObject);
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            return;
        }
    }

    @Test
    public void getFromRegistryTest(){
        GameObject object1 , object2;

        gameRegistry.addPrototype(foregroundGameObject.getType(),foregroundGameObject);
        gameRegistry.addPrototype(backgroundGameObject.getType(), backgroundGameObject);
        try {
            object1 = gameRegistry.getPrototype(backgroundGameObject.getType());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            return;
        }

        try{
            object2 = gameRegistry.getPrototype(foregroundGameObject.getType());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            return;
        }

        Assertions.assertNotNull(object1);
        Assertions.assertNotNull(object2);
    }
}
