package builder.configuration;

public class AppConfigMain {
    public static void main(String[] args) {
        ConfigurationSetting.ConfigSettingBuilder configSettingBuilder = ConfigurationSetting.ConfigSettingBuilder.toBuilder()
                .setServerUrl("a.com")
                .setPort(3883)
                .setEnableLogging(true);
        try {
            ConfigurationSetting configurationSetting = configSettingBuilder.build();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
