package application.backend.repository;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface()
public interface Perform<T> {
    T get(Connection connection) throws SQLException;
}
