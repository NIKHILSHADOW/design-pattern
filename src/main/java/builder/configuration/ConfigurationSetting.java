package builder.configuration;

public class ConfigurationSetting {
    // fields declared final as it need immutable instance
    private String serverUrl;
    private Integer port;
    private Boolean enableLogging;

    // fields are declared private, so that field values can only be intialised inside class, so
    // we can validate the fields
    private ConfigurationSetting(){}

    public static class ConfigSettingBuilder{
        private String serverUrl;
        private Integer port;
        private Boolean enableLogging;

        private ConfigSettingBuilder(){};

        public static ConfigSettingBuilder toBuilder(){
            return new ConfigSettingBuilder();
        }

        public ConfigurationSetting build(){
            if(!validServerUrl(this.serverUrl)){
                throw new RuntimeException("wrong url, please check!!!");
            }

            if(!validPort(this.port)){
                throw new RuntimeException("wrong port, please check!!!");
            }

            if(!validEnableLogging(enableLogging)){
                throw new RuntimeException("wrong enableLogginf field, please check!!!");
            }

            ConfigurationSetting configurationSetting = new ConfigurationSetting();
            configurationSetting.serverUrl = this.serverUrl;
            configurationSetting.port = this.port;
            configurationSetting.enableLogging = this.enableLogging;
            return configurationSetting;
        }

        Boolean validServerUrl(String serverUrl){
            // check based on requirement

            return true;
        }

        Boolean validPort(Integer port){
            // check based on requirement

            return true;
        }

        Boolean validEnableLogging(Boolean enableLogging){
            // check based on requirement

            return true;
        }

        public ConfigSettingBuilder setServerUrl(String serverUrl) {
            this.serverUrl = serverUrl;
            return this;
        }

        public ConfigSettingBuilder setPort(Integer port) {
            this.port = port;
            return this;
        }

        public ConfigSettingBuilder setEnableLogging(Boolean enableLogging) {
            this.enableLogging = enableLogging;
            return this;
        }
    }

}
