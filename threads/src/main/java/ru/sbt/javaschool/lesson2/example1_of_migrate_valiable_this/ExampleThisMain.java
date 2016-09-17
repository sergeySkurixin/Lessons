package ru.sbt.javaschool.lesson2.example1_of_migrate_valiable_this;

import java.util.*;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
//person меняется, не смотря на то что мы сделали его неизменяемым(immutable)
//    причина в Date
public class ExampleThisMain {

    static final List<String> COMMON_EXTENSIONS = new ArrayList<>(Arrays.asList(".txt",".pdf"));
    public static void main(String[] args) {
        Date birthday = new Date();
        Person person = new Person("Ivan", birthday);
        System.out.println(person);
        birthday.setTime(12313);
//        birthday.getTime()
        System.out.println(person);



        COMMON_EXTENSIONS.add(".doc");
    }
}
