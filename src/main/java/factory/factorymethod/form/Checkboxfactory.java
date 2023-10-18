package factory.factorymethod.game;

public class Checkboxfactory implements Factory{
    @Override
    public Checkbox create() {
        return new Checkbox();
    }

}
