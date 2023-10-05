package builder.configuration;

import lombok.Setter;
@Setter
public class ConfigSettingParam {
    private String serverUrl;
    private Integer port;
    private Boolean enableLogging;

    public ConfigSettingParam(String serverUrl, Integer port, Boolean enableLogging){
        this.enableLogging=enableLogging;
        this.port=port;
        this.serverUrl=serverUrl;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public Integer getPort() {
        return port;
    }

    public Boolean getEnableLogging() {
        return enableLogging;
    }
}
