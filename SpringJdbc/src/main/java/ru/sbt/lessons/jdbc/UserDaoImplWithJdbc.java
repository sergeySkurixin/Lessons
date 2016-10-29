package ru.sbt.lessons.jdbc;

import ru.sbt.lessons.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO for app users
 */
public class UserDaoImplWithJdbc implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDaoImplWithJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> findByLogin(String login) {
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

    public boolean create(User user) {
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

    public boolean update(User user) {
        return false;
    }

    public List<User> list() {
        return jdbcTemplate.execute(connection -> {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("select id, login, password_hash from user")
            ) {
                List<User> users = new ArrayList<User>();
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
