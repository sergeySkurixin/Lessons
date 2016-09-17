package ru.sbt.javaschool.lesson2.example4_deadlock;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class Account {

    void transfer(Account from) {
        synchronized (this) {
            doLongOperation();
            synchronized (from) {
            }
        }

    }

    void doLongOperation() {
        try {
            Thread.sleep(123L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
