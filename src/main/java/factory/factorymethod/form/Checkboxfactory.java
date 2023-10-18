package factory.factorymethod.form;

public class Checkboxfactory implements Factory{
    @Override
    public Checkbox create() {
        return new Checkbox();
    }

}
