package factory.factorymethod.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorymethodTest {

    @Test
    public void ButtonFactoryTest(){
        Buttonfactory buttonfactory = new Buttonfactory();
        Assertions.assertNotNull(buttonfactory);
        Assertions.assertTrue(buttonfactory instanceof Buttonfactory);
        Assertions.assertTrue(buttonfactory instanceof Factory);
    }

    @Test
    public void buttonTest(){
        Buttonfactory buttonfactory = new Buttonfactory();
        FormObject button = buttonfactory.create();
        Assertions.assertNotNull(buttonfactory);
        Assertions.assertTrue(button instanceof Button);
    }

    @Test
    public void CheckBoxFactoryTest() {
        Checkboxfactory checkboxfactory = new Checkboxfactory();
        Assertions.assertNotNull(checkboxfactory);
        Assertions.assertTrue(checkboxfactory instanceof  Checkboxfactory);
    }

    @Test
    public void CheckBoxTest() {
        Checkboxfactory checkboxfactory = new Checkboxfactory();
        FormObject checkbox = checkboxfactory.create();
        Assertions.assertNotNull(checkboxfactory);
        Assertions.assertNotNull(checkbox);
        Assertions.assertTrue(checkbox instanceof Checkbox);
    }
}
