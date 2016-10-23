package ru.sbt.sql.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SBTJavastudent on 22.10.2016.
 */
public class JdbcTemplate {

    private String url;

    public JdbcTemplate(String url) {
        this.url = url;
    }

    <T> T execute(JdbcAction<T> action){
        try (Connection connection = DriverManager.getConnection(url)) {
            return action.execute(connection);
        }catch (Exception e) {
            throw new IllegalStateException("Execute error", e);
        }
    }

    public interface JdbcAction<T> {
        T execute(Connection connection) throws Exception;
    }
}
