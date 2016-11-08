package ru.sbt.lessons.jdbc;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 22.10.2016.
 */
public class DaoDemo {

    private final UserDaoImplWithJdbc userDaoImplWithJdbc;

    public DaoDemo(String url) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(url);
        userDaoImplWithJdbc = new UserDaoImplWithJdbc(jdbcTemplate);
    }

    public static void main(String[] args) throws Exception {
        DaoDemo daoDemo = new DaoDemo("jdbc:h2:./SpringJdbc/database/app");
        daoDemo.findByLogin("root");
    }

    private void findByLogin(String login) {
        Optional<User> user = userDaoImplWithJdbc.findByLogin(login);
        if (user.isPresent()) {
            System.out.println(user.get());
        } else {
            System.out.println("User not found: " + login);
        }

    }

    public void createUser(String login, String password) {
        System.out.println("****************** Create start");
        User user = new User();
        user.setLogin(login);
        String md5Hex = DigestUtils.md5Hex(password);
        user.setPasswordMd5(md5Hex);
        boolean result = userDaoImplWithJdbc.create(user);
        System.out.println("****************** Create end. result: " + result);
    }

    public void listUsers() {
        System.out.println("****************** List start");
        List<User> users = userDaoImplWithJdbc.list();
        users.forEach(System.out::println);
        System.out.println("****************** List end");
    }
}
