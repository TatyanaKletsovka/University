package by.epam.finalproject.pool;

import by.epam.finalproject.resource.DBManager;

public class DbConfig {

    private static final String POOL_SIZE_PROPERTY_KEY = "db.poolSize";
    private static final String USER_PROPERTY_KEY = "db.user";
    private static final String PASSWORD_PROPERTY_KEY = "db.password";
    private static final String AUTO_RECONNECT_PROPERTY_KEY = "db.autoReconnect";
    private static final String CHARACTER_ENCODING_PROPERTY_KEY = "db.encoding";
    private static final String UNICODE_PROPERTY_KEY = "db.useUnicode";
    private static final String URL_PROPERTY_KEY = "db.url";

    private static final String connectionUrlValue = DBManager.getProperty(URL_PROPERTY_KEY);
    private static final String userValue = DBManager.getProperty(USER_PROPERTY_KEY);
    private static final String passwordValue = DBManager.getProperty(PASSWORD_PROPERTY_KEY);
    private static final String autoReconnectValue = DBManager.getProperty(AUTO_RECONNECT_PROPERTY_KEY);
    private static final String characterEncodingValue = DBManager.getProperty(CHARACTER_ENCODING_PROPERTY_KEY);
    private static final String unicodeValue = DBManager.getProperty(UNICODE_PROPERTY_KEY);
    private static final String poolSizeValue = DBManager.getProperty(POOL_SIZE_PROPERTY_KEY);

    public DbConfig() {
    }

    String getConnectionUrlValue() {
        return connectionUrlValue;
    }

    String getUserValue() {
        return userValue;
    }

    String getPasswordValue() {
        return passwordValue;
    }

    String getAutoReconnectValue() {
        return autoReconnectValue;
    }

    String getCharacterEncodingValue() {
        return characterEncodingValue;
    }

    String getUnicodeValue() {
        return unicodeValue;
    }

    String getPoolSizeValue() {
        return poolSizeValue;
    }
}
