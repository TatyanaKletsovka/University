package by.epam.finalproject.dao;

import by.epam.finalproject.builder.Builder;
import by.epam.finalproject.entity.Entity;
import by.epam.finalproject.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractDao<K, T extends Entity> {

    public static final String ID_COLUMN = "id";

    private Connection connection;
    protected ConnectionManager connectionManager;

    public AbstractDao() {
        this.connectionManager = new ConnectionManager();
        this.connection = connectionManager.getConnection();
    }

    protected List<T> executeQuery(String query, Builder<T> builder, String... params) throws DaoException {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = builder.build(resultSet);
                entities.add(entity);
            }
            return entities;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected boolean executeUpdate(String query, String... params) throws DaoException {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            if (statement.executeUpdate() > 0) {
                return true;
            } else return false;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public abstract List<T> findAll();
//    public abstract T selectEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
    protected abstract T buildEntity(ResultSet resultSet) throws DaoException;

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() {
        connectionManager.close();
    }

    // Получение экземпляра PrepareStatement
    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
                returnConnectionInPool();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


/*    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            // лог о невозможности закрытия Statement
        }
    }

    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // генерация исключения, т.к. нарушается работа пула
        }
    }*/


}
