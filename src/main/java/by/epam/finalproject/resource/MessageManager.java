package by.epam.finalproject.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
    public static final Locale DEFAULT_LOCALE = new Locale("", "");

    // класс извлекает информацию из файла messages.properties
    private MessageManager() {

    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    public static void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("messages", locale);
    }
}
