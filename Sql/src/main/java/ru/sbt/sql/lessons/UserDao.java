package ru.sbt.sql.lessons;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Dao for app users
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    Optional<User> findByLogin(String login) throws Exception {
        return jdbcTemplate.execute(connection -> {

            try (PreparedStatement statement = connection.prepareStatement(
                    "select id, login, password_hash from user " +
                            "where login = ?");
            ) {
                statement.setString(1, login);
                ResultSet resultSet = statement.executeQuery();
                if (!resultSet.next()) {
                    return Optional.empty();
                }

                User user = new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                return Optional.of(user);
            }
        });
    }

    boolean remove(String login) {
        return jdbcTemplate.execute(connection -> {
            PreparedStatement checkUser = connection.prepareStatement("select login from user where login=?");
            checkUser.setString(1,login);
            ResultSet resultSet = checkUser.executeQuery();
            if(!resultSet.next()){
                return false;
            }
            else {
                PreparedStatement statement = connection.prepareStatement("delete from user where login=?");
                statement.setString(1, login);
                int update = statement.executeUpdate();
                return update > 0;
            }
        });
    }

    boolean create(User user) throws Exception {
        return jdbcTemplate.execute(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into user (login, password_hash)" +
                            "values (?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPasswordMd5());
            int result = statement.executeUpdate();
            return result == 1;
        });
    }

    boolean update(User user) {
        return false;
    }

    List<User> list() throws Exception {
        return jdbcTemplate.execute(connection -> {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("select id, login, password_hash from user")
            ) {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    );
                    users.add(user);
                }
                return users;
            }
        });
    }
}
