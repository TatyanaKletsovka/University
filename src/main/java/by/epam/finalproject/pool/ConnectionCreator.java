package by.epam.finalproject.pool;

import by.epam.finalproject.resource.DBManager;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class ConnectionCreator {

    private static final String POOL_SIZE_PROPERTY_KEY = "db.poolSize";
    private static final String USER_PROPERTY_KEY = "db.user";
    private static final String PASSWORD_PROPERTY_KEY = "db.password";
    private static final String AUTO_RECONNECT_PROPERTY_KEY = "db.autoReconnect";
    private static final String CHARACTER_ENCODING_PROPERTY_KEY = "db.encoding";
    private static final String UNICODE_PROPERTY_KEY = "db.useUnicode";
    private static final String URL_PROPERTY_KEY = "db.url";

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String AUTO_RECONNECT = "autoReconnect";
    private static final String CHARACTER_ENCODING = "characterEncoding";
    private static final String USE_UNICODE = "useUnicode";

    /**
     * Create pool of connections to chosen database.
     *
     * @return LinkedList object.
     */
    public LinkedList<Connection> createPool() {
        LinkedList<Connection> pool = new LinkedList<>();
        String poolSizeValue = DBManager.getProperty(POOL_SIZE_PROPERTY_KEY);
        int currentPoolSize = Integer.parseInt(poolSizeValue);

        for (int listIndex = 0; listIndex < currentPoolSize; listIndex++) {
            Connection connection = create();

            pool.addLast(connection);
        }

        System.out.println("Pool was created successful.");
        return pool;
    }

    /**
     * Create connection to chosen database using properties.
     *
     * @return created connection.
     */
    private Connection create() {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Driver was registered successful.");
        } catch (SQLException exception) {
            System.out.println("SQL exception was detected during driver registration.");
            throw new ExceptionInInitializerError("Driver hasn't been registered. " + exception.getMessage());
        }

        String connectionUrlValue = DBManager.getProperty(URL_PROPERTY_KEY);
        String userValue = DBManager.getProperty(USER_PROPERTY_KEY);
        String passwordValue = DBManager.getProperty(PASSWORD_PROPERTY_KEY);
        String autoReconnectValue = DBManager.getProperty(AUTO_RECONNECT_PROPERTY_KEY);
        String characterEncodingValue = DBManager.getProperty(CHARACTER_ENCODING_PROPERTY_KEY);
        String unicodeValue = DBManager.getProperty(UNICODE_PROPERTY_KEY);

        Properties properties = new Properties();
        properties.put(USER, userValue);
        properties.put(PASSWORD, passwordValue);
        properties.put(AUTO_RECONNECT, autoReconnectValue);
        properties.put(CHARACTER_ENCODING, characterEncodingValue);
        properties.put(USE_UNICODE, unicodeValue);

        try {
            Connection connection = DriverManager.getConnection(connectionUrlValue, properties);
            System.out.println("Connection was created successful.");
            return connection;
        } catch (SQLException exception) {
            System.out.println("SQL exception was detected during connection creating.");
            throw new ExceptionInInitializerError("Connection hasn't been created. " + exception.getMessage());
        }
    }

}
