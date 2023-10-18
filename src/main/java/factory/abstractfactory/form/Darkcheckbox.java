package factory.abstractfactory.form;

public class Darkcheckbox extends Checkbox{
    private Darkcheckbox(){

    }
    @Override
    public Checkbox create() {
        return new Darkcheckbox();
    }
}
