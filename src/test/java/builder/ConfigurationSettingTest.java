package builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigurationSettingTest {

    @Test
    public void configSettingTest(){
        try {
            ConfigurationSetting configurationSetting = new ConfigurationSetting("yil.com", 9944, true);
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage());
        }
    }
}
