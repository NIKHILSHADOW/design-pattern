package builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigurationSettingTest {

    @Test
    public void configSettingTest(){
        Map<String, Object> hm = new HashMap<>();
        hm.put("url","xyz.com");
        hm.put("port",3838);
        hm.put("enableLogging",true);
        try {
            ConfigurationSetting configurationSetting = new ConfigurationSetting(hm);
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage());
        }
    }
}
