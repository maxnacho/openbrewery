package utilities;

import java.io.IOException;
import java.net.URL;

public class OpenBreweryProperties {

    private static final java.util.Properties properties;

    static {
        properties = new java.util.Properties();
        URL props = ClassLoader.getSystemResource("config.properties");
        try {
            properties.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OpenBreweryProperties() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
