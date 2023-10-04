# BUILDER DESIGN PATTERN

Let's take example of ConfigurationSetting class for our project.
Here instance need to be immutable, same throughout the execution.
And fail instance creation when fields are not valid.

When creating class sometimes we require 
1. Object to be immutable.
2. Not many arguments in constructor.
3. Not too many constructors
4. Failing instance creation, if field is not valid.
5. TypeSafety.
6. No voilation of solid principles.

Let's First create our basic class for configurationsetting

```java
// file - ConfigurationSetting.java

public class ConfigurationSetting {
    // fields declared final as it need immutable instance
    private final String serverUrl;
    private final Integer port;
    private final Boolean enableLogging;

    // fields are declared private, so that field values can only be intialised inside class, so
    // we can validate the fields
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

// file - AppConfig.java

public class AppConfig{
    public static void main(String[] args){
        ConfigurationSetting configurationSetting = new ConfigurationSetting("op.com",7484,true);
    }
}
```

The above solves the immutable problem and failing object creation when given invalid fields.
But we are sending too many arguments to constructor, so if we send want only some arguments, it would be problematic.

