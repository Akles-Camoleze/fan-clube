package application.backend.repository;

import java.sql.Connection;

@FunctionalInterface()
public interface Perform<T> {
    T get(Connection connection);
}
