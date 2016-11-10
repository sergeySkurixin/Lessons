package ru.sbt.lessons.spring_jdbc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.sbt.lessons.UserDao;
import ru.sbt.lessons.jdbc.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by SBTJavastudent on 29.10.2016.
 */

@Repository
public class UserDaoImplWithSpringJdbc implements UserDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImplWithSpringJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        SqlParameterSource params = new MapSqlParameterSource("login", login);
        List<Map<String, Object>> userList = jdbcTemplate.queryForList("select * from user where login = :login", params);
        if (userList.isEmpty()) {
            return Optional.empty();
        }
        Map<String, Object> userMap = userList.get(0);
        User user = new User(
                ((Number) userMap.get("ID")).longValue(),
                (String) userMap.get("LOGIN"),
                (String) userMap.get("PASSWORD_HASH")
        );

        return Optional.of(user);
    }

    @Override
    public boolean create(User user) {

        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        int result = jdbcTemplate.update("insert into user (login, password_hash) " +
                "values(:login, :passwordMd5)", params);
        return result == 1;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
