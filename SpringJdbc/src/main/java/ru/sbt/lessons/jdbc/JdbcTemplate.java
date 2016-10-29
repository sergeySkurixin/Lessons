package ru.sbt.lessons.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 22.10.2016.
 */
public class JdbcTemplate {
    private String url;

    public JdbcTemplate(String url) {
        this.url = url;
    }

    <T> T execute(JdbcAction<T> action) {
        try (Connection connection = openConnection()) {
            return action.execute(connection);
        } catch (Exception e) {
            throw new IllegalStateException("Execute error", e);
        }
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public interface JdbcAction<T> {
        T execute(Connection connection) throws Exception;
    }
}
