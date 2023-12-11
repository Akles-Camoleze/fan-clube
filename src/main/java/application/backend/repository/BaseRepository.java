package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.BaseEntity;
import application.backend.entities.Inscricao;
import application.database.DataBase;
import application.database.DbException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.function.Supplier;

public abstract class BaseRepository<T extends BaseEntity> {
    static final Transaction transaction = new Transaction();

    protected final String tableName;

    protected BaseRepository(String tableName) {
        this.tableName = tableName;
    }

    abstract T find(Integer id);

    abstract <K extends DataTransferObject> K find(Integer id, Class<K> clazz);

    abstract <K extends DataTransferObject> List<K> findAll(Class<K> clazz);

    abstract List<T> findAll();

    public T save(Connection connection, T entity) throws SQLException {
        return null;
    }

    abstract T save(T entity);

    public <K> K performOperation(Perform<K> operation) {
        try {
            Connection connection = DataBase.getConnection();
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
    public <K extends BaseEntity> K performTransaction(List<Supplier<? extends BaseEntity>> operations) {
        Connection connection = DataBase.getConnection();
        K lastResult = null;
        boolean canClose = false;
        try {
            if (!transaction.isTransactionOpened()) {
                transaction.setTransactionOpened(true);
                connection.setAutoCommit(false);
                canClose = true;
            }

            Supplier<K> lastOperation = (Supplier<K>) operations.remove(operations.size() - 1);
            for (Supplier<?> operation : operations) {
                operation.get();
            }
            lastResult = lastOperation.get();

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

    public <K extends DataTransferObject> K runQuery(PreparedStatement st, Class<K> clazz) throws SQLException {
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

    public <K extends DataTransferObject> List<K> runQuery(PreparedStatement st, Class<K> clazz, List<K> data) throws SQLException {
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


    public void performOperation(ConnectionConsumer operation) {
        try {
            Connection connection = DataBase.getConnection();
            operation.accept(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (!transaction.isTransactionOpened()) {
                DataBase.closeConnection();
            }
        }
    }

    public void delete(T entity) {
        performOperation(connection -> {
            String sql = "DELETE FROM `fan_club`." + tableName + " WHERE id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, entity.getId());
            st.executeUpdate();
            DataBase.closeStatement(st);
        });
    }
}
