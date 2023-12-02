package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.database.DataBase;
import application.database.DbException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public interface BaseRepository<T> {
    T find(Integer id);
    <K extends DataTransferObject> K find(Integer id, Class<K> clazz);

    <K extends DataTransferObject> List<K> findAll(Class<K> clazz);
    List<T> findAll();

    void save(T entity);

    default <K> K performOperation(Perform<K> operation) {
        try (Connection connection = DataBase.getConnection()) {
            return operation.get(connection);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
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
