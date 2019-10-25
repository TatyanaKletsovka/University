package by.epam.finalproject.pool;

import by.epam.finalproject.controller.Controller;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class ConnectionCreator {

    private final static Logger LOGGER = Logger.getLogger(Controller.class);

    DbConfig dbConfig;

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String AUTO_RECONNECT = "autoReconnect";
    private static final String CHARACTER_ENCODING = "characterEncoding";
    private static final String USE_UNICODE = "useUnicode";

    public ConnectionCreator() {
        this.dbConfig = new DbConfig();
    }

    /**
     * Create pool of connections to chosen database.
     *
     * @return LinkedList object.
     */

    public LinkedList<Connection> createPool() {
        LinkedList<Connection> pool = new LinkedList<>();
        String poolSizeValue = dbConfig.getPoolSizeValue();
        int currentPoolSize = Integer.parseInt(poolSizeValue);

        for (int listIndex = 0; listIndex < currentPoolSize; listIndex++) {
            Connection connection = create();

            pool.addLast(connection);
        }

        LOGGER.debug("Pool was created successful.");
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
            LOGGER.debug("Driver was registered successful.");
        } catch (SQLException exception) {
            LOGGER.debug("SQL exception was detected during driver registration.");
            throw new ExceptionInInitializerError("Driver hasn't been registered. " + exception.getMessage());
        }

        Properties properties = new Properties();
        properties.put(USER, dbConfig.getUserValue());
        properties.put(PASSWORD, dbConfig.getPasswordValue());
        properties.put(AUTO_RECONNECT, dbConfig.getAutoReconnectValue());
        properties.put(CHARACTER_ENCODING, dbConfig.getCharacterEncodingValue());
        properties.put(USE_UNICODE, dbConfig.getUnicodeValue());

        String connectionUrlValue = dbConfig.getConnectionUrlValue();
        try {
            Connection connection = DriverManager.getConnection(connectionUrlValue, properties);
            LOGGER.debug("Connection was created successful.");
            return connection;
        } catch (SQLException exception) {
            LOGGER.debug("SQL exception was detected during connection creating.");
            throw new ExceptionInInitializerError("Connection hasn't been created. " + exception.getMessage());
        }
    }

}
