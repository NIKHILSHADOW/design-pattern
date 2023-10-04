package builder;

import java.util.Map;

public class ConfigurationSetting {
    // fields declared final as it need immutable instance
    private String serverUrl;
    private Integer port;
    private Boolean enableLogging;

    // fields are declared private, so that field values can only be intialised inside class, so
    // we can validate the fields
    public ConfigurationSetting(Map<String,Object> values){

        if(!isValidUrl((String)values.get("url"))){
            throw new RuntimeException("url is wrong please check!!");
        }

        if(!isValidPort((Integer) values.get("port"))){
            throw new RuntimeException("port is wrong, please check!!");
        }

        if(!isValidEnableLogging((Boolean) values.get("enableLogging"))){
            throw new RuntimeException("enalble logging field is wrong!!");
        }

        this.serverUrl = (String) values.get("url");
        this.port = (Integer) values.get("port");
        this.enableLogging = (Boolean) values.get("enableLogging");
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
