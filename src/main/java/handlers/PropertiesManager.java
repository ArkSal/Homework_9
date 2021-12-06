package handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties property;
    private static FileInputStream inputStream;

    public static String getStringProperty(String propertiesKey) {
        property = new Properties();
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") +
                    "/resources/config.properties");
            property.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(propertiesKey);
    }
}
