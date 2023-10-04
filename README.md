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
And also if we are sending arguments of same datatype in different order by mistake, it will be prone to error. 

so we comeup with solution having multiple constructor, using OOP principle constructor overloading.
as the fields are final, if we want to do that, it fails, so we need to remove final.

But if we remove final, they can be reintialised so make sure.
1. No setters present
2. Make sure variables are private, so no outside class can change values.

to intialise we will use parameterised constructors.



```java
// file - ConfigurationSetting

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

```

Now, we can set only needed fields, but how many constructors we need, and is it manageable?
No it is not.
It also creates Telescopic Constructor Anti pattern problem
* Anti-pattern : The code pattern, which is not preferred to use in any code base. It creates more problems.
* Telescopic : increasing number of arguments, it looks like telescope.

```
telescopic 
| \
|  \
|   \
|    \ 
|     \ 
|      \
|       \
```

So to avoid too many fields in argument, and wanna send only required fields and need to be send at a time,
then we comeup with

HashMap<>
Obviously we use key as String.
But what should be datatype of value, because for url it need to be String, for Port it need to be Integer.

So to handle all kinds, we use Subtyping , so Object type.

AS Object is parent of all wrapper classes.

HashMap<String, Object>

```java
// file - ConfigurationSetting.java

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


// file - ConfigSettingTest.java
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
```

It solved, 
* problem of adding too many arguments to constructor.
* problem of immutabilty
* problem of failing instance creation by validating fields.

But 
* As key's("url","port") this by mistyping creates extra problems.
* Changing key values in one class makes other class open for modification, so violates open-close principle.
* No type Safety, because we are casting from object to requirement datatype. Also it is hectic to always cast.

