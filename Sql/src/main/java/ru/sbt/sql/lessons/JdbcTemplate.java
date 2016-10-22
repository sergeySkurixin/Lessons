package ru.sbt.sql.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * Created by SBTJavastudent on 22.10.2016.
 */
public class JdbcTemplate {

    private String url;

    public JdbcTemplate(String url) {
        this.url = url;
    }

    <T> T execute(JdbcAction<T> action) throws Exception {
        try (Connection connection = openConnection()) {
            return action.execute(connection);
        }
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public interface JdbcAction<T> {
        T execute(Connection connection) throws Exception;
    }
}
