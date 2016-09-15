package ru.sbt.javaschool.lesson12_threads.thread2;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class AccountMain {
    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        for (int i = 0; i < 10; i++) {
            Thread task = new Thread(accountExample);
            task.start();
        }
    }
}
