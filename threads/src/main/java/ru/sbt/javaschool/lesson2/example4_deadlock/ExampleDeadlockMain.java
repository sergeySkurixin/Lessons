package ru.sbt.javaschool.lesson2.example4_deadlock;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class ExampleDeadlockMain {
    public static void main(String[] args) {
        Account accountVasia = new Account();
        Account accountIvan = new Account();

        new Thread(() -> {
            accountVasia.transfer(accountIvan);
        }, "thread Ivan->Vasya").start();
        new Thread(() -> {
            accountIvan.transfer(accountVasia);
        }, "thread Vasya->Ivan").start();
    }
}
