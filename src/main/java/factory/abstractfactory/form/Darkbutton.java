package factory.abstractfactory.form;

public class Darkbutton extends Button{
    @Override
    public Button create() {
        return new Darkbutton();
    }
}
