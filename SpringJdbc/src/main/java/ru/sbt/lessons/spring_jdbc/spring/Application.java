package ru.sbt.lessons.spring_jdbc.spring;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sbt.lessons.UserDao;
import ru.sbt.lessons.jdbc.JdbcTemplate;
import ru.sbt.lessons.jdbc.User;

import javax.sql.DataSource;

/**
 * Created by SBTJavastudent on 29.10.2016.
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);


        UserDao userDao = context.getBean(UserDao.class);

        boolean result = userDao.create(new User(null, "user2", DigestUtils.md5Hex("password")));
        System.out.println(result);
    }
}
