package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.BaseEntity;
import application.database.DataBase;
import application.database.DbException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.function.Consumer;

public interface BaseRepository<T> {
    Transaction transaction = new Transaction();

    T find(Integer id);

    <K extends DataTransferObject> K find(Integer id, Class<K> clazz);

    <K extends DataTransferObject> List<K> findAll(Class<K> clazz);

    List<T> findAll();

    default T save(Connection connection, T entity) throws SQLException {
        return null;
    }

    T save(T entity);

    default <K> K performOperation(Perform<K> operation) {
        try (Connection connection = DataBase.getConnection()) {
            return operation.get(connection);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            if (!transaction.isTransactionOpened()) {
                DataBase.closeConnection();
            }
        }
    }

    @SuppressWarnings("unchecked")
    default <K extends BaseEntity> K performTransaction(List<Perform<? extends BaseEntity>> operations) {
        Connection connection = DataBase.getConnection();
        K lastResult = null;
        boolean canClose = false;
        try {
            if (!transaction.isTransactionOpened()) {
                transaction.setTransactionOpened(true);
                connection.setAutoCommit(false);
                canClose = true;
            }

            Perform<K> lastOperation = (Perform<K>) operations.remove(operations.size() - 1);
            for (Perform<?> operation : operations) {
                operation.get(connection);
            }
            lastResult = lastOperation.get(connection);

            if (canClose) {
                connection.commit();
            }

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new DbException(e.getMessage());
            }
        } finally {
            if (canClose) {
                DataBase.closeConnection();
                transaction.setTransactionOpened(false);
            }
        }

        return lastResult;
    }

    default <K extends DataTransferObject> K runQuery(PreparedStatement st, Class<K> clazz) throws SQLException {
        ResultSet result = st.executeQuery();
        if (result.next()) {
            try {
                Constructor<K> constructor = clazz.getDeclaredConstructor(ResultSet.class);
                return constructor.newInstance(result);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return null;
    }

    default <K extends DataTransferObject> List<K> runQuery(PreparedStatement st, Class<K> clazz, List<K> data) throws SQLException {
        ResultSet result = st.executeQuery();
        try {
            while (result.next()) {
                Constructor<K> constructor = clazz.getDeclaredConstructor(ResultSet.class);
                data.add(constructor.newInstance(result));
            }
        } catch (SQLException e) {
            throw new DbException("Db: " + e.getMessage());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage());
        }
        return data;
    }


    default void performOperation(Consumer<Connection> operation) {
        try (Connection connection = DataBase.getConnection()) {
            operation.accept(connection);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }
}
