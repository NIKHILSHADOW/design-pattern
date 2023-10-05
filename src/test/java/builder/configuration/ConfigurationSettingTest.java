package builder.configuration;

import org.junit.jupiter.api.Test;

public class ConfigurationSettingTest {

    @Test
    public void configSettingTest(){
        ConfigurationSetting.ConfigSettingBuilder configSettingBuilder = ConfigurationSetting.ConfigSettingBuilder.toBuilder()
        .setServerUrl("a.com")
        .setPort(3733)
        .setEnableLogging(true);
        try {
            ConfigurationSetting configurationSetting = configSettingBuilder.build();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
