package by.epam.finalproject.dao;

import by.epam.finalproject.builder.Builder;
import by.epam.finalproject.entity.Entity;
import by.epam.finalproject.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractDao<K, T extends Entity> {

    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public AbstractDao() {
    }

    protected List<T> executeQuery(String query, Builder<T> builder, String... params) throws DaoException {
        try {
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
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public abstract List<T> findAll() throws DaoException;
    public abstract T findById(K id) throws DaoException;
    public abstract boolean delete(K id) throws DaoException;

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() {
      //  proxyConnection.close();
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


}
