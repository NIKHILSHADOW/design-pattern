package builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigurationSettingTest {

    @Test
    public void configSettingTest(){
        ConfigurationSetting.ConfigSettingBuilder configSettingBuilder = new ConfigurationSetting.ConfigSettingBuilder();
        configSettingBuilder.setServerUrl("a.com");
        configSettingBuilder.setPort(3733);
        configSettingBuilder.setEnableLogging(true);
        try {
            ConfigurationSetting configurationSetting = configSettingBuilder.build();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
