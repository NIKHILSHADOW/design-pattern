package factory.abstractfactory.form;

import factory.factorymethod.form.Button;
import factory.factorymethod.form.Checkbox;

public interface FormFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}
