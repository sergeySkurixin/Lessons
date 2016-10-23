package ru.sbt.sql.lessons;

import org.apache.commons.io.FileUtils;
import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SBTJavastudent on 22.10.2016.
 */
public class DatabaseUpdater {

    public static void main(String[] args) throws Exception {
//        new DatabaseUpdater().executeScript("C:\\Users\\SBTJavastudent\\IdeaProjects\\Lessons\\Sql\\src\\main\\sql\\user.sql");
        new DatabaseUpdater().executeScript("Sql/sql/user.sql");

    }

    private void executeScript(String filename) throws IllegalAccessException, IOException {
        try{
            //Path sqlScript = Paths.get(new URI(filename));
            String sqlScript = FileUtils.readFileToString(new File(filename));
            executeSql(sqlScript);

        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad script: " + filename, e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read file: " + filename, e);
        }
    }

    private static void executeSql(String sql) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:h2:C:/Users/скурихин/IdeaProjects/Lessons//Sql/database/app");
            Statement statement = connection.createStatement()){
            boolean execute = statement.execute(sql);
            System.out.println("---------------------------------");
            System.out.println("State:" + execute);
            System.out.println("SQL: " + sql);
            System.out.println("---------------------------------");
        }
    }
}
