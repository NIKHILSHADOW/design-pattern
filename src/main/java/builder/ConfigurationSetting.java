package builder;

public class ConfigurationSetting {
    // fields declared final as it need immutable instance
    private String serverUrl;
    private Integer port;
    private Boolean enableLogging;

    // fields are declared private, so that field values can only be intialised inside class, so
    // we can validate the fields

    public ConfigurationSetting(String serverUrl, Integer port){
        if(!isValidUrl(serverUrl)){
            throw new RuntimeException("url is wrong please check!!");
        }

        if(!isValidPort(port)){
            throw new RuntimeException("port is wrong, please check!!");
        }

        this.serverUrl = serverUrl;
        this.port=port;
    }

    public ConfigurationSetting(String serverUrl, Integer port, Boolean enableLogging){
        if(!isValidUrl(serverUrl)){
            throw new RuntimeException("url is wrong please check!!");
        }

        if(!isValidPort(port)){
            throw new RuntimeException("port is wrong, please check!!");
        }

        if(!isValidEnableLogging(enableLogging)){
            throw new RuntimeException("enalble logging field is wrong!!");
        }

        this.serverUrl = serverUrl;
        this.port=port;
        this.enableLogging=enableLogging;
    }

    Boolean isValidUrl(String serverUrl){
        // check according to requirement.

        return true;
    }

    Boolean isValidPort(Integer port){
        // check according to requirement

        return true;
    }

    Boolean isValidEnableLogging(Boolean enableLogging){
        // check according to requirement

        return true;
    }
}
