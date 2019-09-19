package by.epam.finalproject.resource;

import java.util.ResourceBundle;

public class DBManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    // класс извлекает информацию из файла database.properties
    public DBManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
