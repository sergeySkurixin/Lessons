package ru.sbt.javaschool.lesson12_threads.thread1;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class ThreadMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread task = new Thread(new SomeTask());
            task.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread task = new MyThread();
            task.start();
        }
        System.out.println("Waiting end of some task");

    }
}
