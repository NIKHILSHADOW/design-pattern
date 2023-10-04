package builder;

import java.util.HashMap;
import java.util.Map;

public class AppConfigMain {
    public static void main(String[] args) {
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
