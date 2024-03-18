package configuration;

import configuration.enums.GenericProperties;
import logger.TestLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationData {

    private static final String CONFIG_PROPERTIES = "config.properties";

    private static String getValue(String fileName, String property) {
        Properties properties = new Properties();

        try {
            properties.load(ConfigurationData.class.getClassLoader().getResourceAsStream(fileName));
            return properties.getProperty(property.toLowerCase());
        } catch (IOException ex) {
            TestLogger.get().log(Level.ERROR, ex.getMessage());
            return null;
        }
    }

    public static String getAddress() {
        return getValue(CONFIG_PROPERTIES, GenericProperties.URL_ADDRESS.getName());
    }

    public static String getBrowser() {
        return getValue(CONFIG_PROPERTIES, GenericProperties.BROWSER.getName());
    }
}