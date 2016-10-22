package ru.sbt.sql.lessons;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * Created by SBTJavastudent on 22.10.2016.
 */
public class DaoDemo {
private final UserDao userDao;

    public DaoDemo(String url) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate("C:\\Users\\SBTJavastudent\\IdeaProjects\\Lessons\\Sql\\src\\main\\sql\\user.sql");
        userDao = new UserDao(jdbcTemplate);
    }

    public static void main(String[] args) throws Exception {
        DaoDemo daoDemo = new DaoDemo("C:\\Users\\SBTJavastudent\\IdeaProjects\\Lessons\\Sql\\src\\main\\sql\\user.sql");
        daoDemo.listUsers();
        daoDemo.createUsers("root","password");
        daoDemo.listUsers();

    }

    private void createUsers(String login, String password) throws Exception {
        System.out.println("**************");
        User user = new User();
        user.setLogin(login);
        user.setPasswordMd5(password);
        boolean result = userDao.create(user);
    }

    private void listUsers() throws Exception {
        System.out.println("**************");
        List<User> users = userDao.list();
        users.forEach(System.out::println);
        System.out.println("*****************");
    }
}
