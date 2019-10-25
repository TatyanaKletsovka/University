package by.epam.finalproject.resource;

import java.util.ResourceBundle;

public class DBManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    public DBManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
