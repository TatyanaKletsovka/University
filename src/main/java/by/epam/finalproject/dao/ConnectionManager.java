package by.epam.finalproject.dao;

import by.epam.finalproject.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager implements AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class);
    private final Connection connection;
//    private ConnectionPool connectionPool;

    /**
     * Instantiates a new ConnectionManager.
     */
    public ConnectionManager() {
        //       connectionPool = ConnectionPool.getInstance();
        connection = ConnectionPool.getInstance().getConnection();
    }

    /**
     * The method starts transaction.
     */
    public void startTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            LOGGER.error("Transaction start failed. ", exception);
        }
    }

    /**
     * The method commits transaction.
     */
    public void commitTransaction() {
        try {
            connection.commit();
        } catch (SQLException exception) {
            LOGGER.error("Transaction commit failed. ", exception);
        }
    }

    /**
     * The method rollback transaction.
     */
    public void rollbackTransaction() {
        try {
            connection.rollback();
        } catch (SQLException exception) {
            LOGGER.error("Transaction rollback failed. ", exception);
        }
    }

    /**
     * This method ends transaction.
     */
    public void endTransaction() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException exception) {
            LOGGER.error("Transaction end failed. ", exception);
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Implementation of AutoCloseable interface to work with try().
     */
    @Override
    public void close() {
        ConnectionPool.getInstance().returnConnection(connection);
    }
}
