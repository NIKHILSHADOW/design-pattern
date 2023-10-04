package builder;

import java.util.HashMap;
import java.util.Map;

public class AppConfigMain {
    public static void main(String[] args) {
        Map<String, Object> hm = new HashMap<>();
        hm.put("url","xyz.com");
        hm.put("port",9399);
        hm.put("enableLogging",true);
        ConfigurationSetting configurationSetting = new ConfigurationSetting(hm);
    }
}
