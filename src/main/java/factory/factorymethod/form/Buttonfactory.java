package factory.factorymethod.game;

public class Buttonfactory implements Factory{
    @Override
    public Button create(){
        return new Button();
    }
}
