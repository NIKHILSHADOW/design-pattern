package factory.factorymethod.form;

public class Buttonfactory implements Factory{
    @Override
    public Button create(){
        return new Button();
    }
}
