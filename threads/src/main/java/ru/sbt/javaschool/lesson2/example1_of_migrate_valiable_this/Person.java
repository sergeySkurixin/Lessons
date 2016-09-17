package ru.sbt.javaschool.lesson2.example1_of_migrate_valiable_this;

import java.util.Date;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class Person {
    private final String name;
    private final Date birthday;

    public Person(String ivan, Date date) {
        this.name = ivan;
        this.birthday = date;
//        this.birthday=new Date(birthday.getTime());
    }

    @Override
    public String toString() {
        return name + " " + birthday.toString();
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }
}
