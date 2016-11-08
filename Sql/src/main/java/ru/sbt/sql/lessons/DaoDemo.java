package ru.sbt.sql.lessons;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;
import java.util.Optional;

/**
 * Created by SBTJavastudent on 22.10.2016.
 */
public class DaoDemo {
    private final UserDao userDao;

    public DaoDemo(String url) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(url);
        userDao = new UserDao(jdbcTemplate);
    }

    public static void main(String[] args) throws Exception {
        DaoDemo daoDemo = new DaoDemo("jdbc:h2:./Sql/database/app");
        daoDemo.listUsers();
        daoDemo.createUsers("root", "password");
        daoDemo.listUsers();
        daoDemo.removeUser(new User("root"));
        daoDemo.listUsers();

    }

    private void removeUser(User user) {
        System.out.println("**************");
        boolean result = userDao.remove(user.getLogin());
        System.out.println("****************** Remove end. result: " + result);
    }

    private void createUsers(String login, String password) throws Exception {
        System.out.println("**************");
        User user = new User();
        user.setLogin(login);
        String md5Hex = DigestUtils.md5Hex(password);
        user.setPasswordMd5(md5Hex);
        boolean result = userDao.create(user);
        System.out.println("****************** Create user \"" + login + "\" end. result: " + result);
    }

    private void listUsers() throws Exception {
        System.out.println("****************** List start");
        List<User> users = userDao.list();
        users.forEach(System.out::println);
        System.out.println("****************** List end");
    }

    private void findByLogin(String login) throws Exception {
        Optional<User> user = userDao.findByLogin(login);
        if (user.isPresent()) {
            System.out.println(user.get());
        } else {
            System.out.println("User not found: " + login);
        }

    }
}
