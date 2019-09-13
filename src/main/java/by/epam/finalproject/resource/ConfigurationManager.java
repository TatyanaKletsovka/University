package by.epam.finalproject.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    // класс извлекает информацию из файла config.properties
    public ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
