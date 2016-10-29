package ru.sbt.lessons.jdbc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by User on 22.10.2016.
 */
public class DatabaseUpdater {

    public static void main(String[] args) throws Exception {
        new DatabaseUpdater().executeScript("sql/user.sql");
    }

    public void executeScript(String fileName) {
        try {
            String sqlScript = FileUtils.readFileToString(new File(fileName));
            executeSql(sqlScript);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad script: " + fileName, e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read file: " + fileName, e);
        }
    }

    private void executeSql(String sql) throws SQLException {
        try (Connection connection =
                     DriverManager.getConnection("jdbc:h2:D:/сбт/jdbc/database/app");
             Statement statement = connection.createStatement()) {
            boolean execute = statement.execute(sql);
            System.out.println("---------------------------------");
            System.out.println("State:" + execute);
            System.out.println("SQL: " + sql);
            System.out.println("---------------------------------");
        }
    }
}
