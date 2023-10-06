package prototype.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameObjectTest {
    BackgroundGameObject backgroundGameObject = new BackgroundGameObject(100,100,200,200,BackgroundGameObjectType.BACK_GROUND);
    ForegroundGameObject foregroundGameObject = new ForegroundGameObject();

    @Test
    public void backgroundObjectTest(){
        Assertions.assertNotNull(backgroundGameObject);
        Assertions.assertEquals(backgroundGameObject.getType(),BackgroundGameObjectType.BACK_GROUND);
        Assertions.assertEquals(backgroundGameObject.getX(),100);
        Assertions.assertEquals(backgroundGameObject.getY(),100);
        Assertions.assertEquals(backgroundGameObject.getWidth(),200);
        Assertions.assertEquals(backgroundGameObject.getHeight(),200);
    }

    @Test
    public void backgroundObjectCloneTest(){
        BackgroundGameObject clone1 = backgroundGameObject.clone();
        Assertions.assertNotNull(clone1);
        Assertions.assertEquals(clone1.getType(),backgroundGameObject.getType(),"After cloning type should be same");
        Assertions.assertEquals(clone1.getHeight(),backgroundGameObject.getHeight(),"After cloning height should be same");
        Assertions.assertEquals(clone1.getX(),backgroundGameObject.getX(),"After cloning x should be same");
        Assertions.assertEquals(clone1.getY(),backgroundGameObject.getY(),"After cloning y should be same");
        Assertions.assertEquals(clone1.getWidth(),backgroundGameObject.getWidth(),"After cloning width should be same");
    }

    @Test
    public void foregroundObjectTest(){
        Assertions.assertNotNull(foregroundGameObject);
    }

    @Test
    public void foregroundObjectCloneTest(){
        ForegroundGameObject clone2 = foregroundGameObject.clone();
        Assertions.assertNotNull(clone2);
        Assertions.assertEquals(clone2.getType(),foregroundGameObject.getType(),"After cloning type should be same");
        Assertions.assertEquals(clone2.getHeight(),foregroundGameObject.getHeight(),"After cloning height should be same");
        Assertions.assertEquals(clone2.getX(),foregroundGameObject.getX(),"After cloning x should be same");
        Assertions.assertEquals(clone2.getY(),foregroundGameObject.getY(),"After cloning y should be same");
        Assertions.assertEquals(clone2.getWidth(),foregroundGameObject.getWidth(),"After cloning width should be same");

    }
}
