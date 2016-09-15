package ru.sbt.javaschool.lesson12_threads.thread1;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class ThrowExceptionSimpleCaseMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThrowExceptionSimpleCase());
//        thread.start();

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getState());
            System.out.println("Exception  has been catch 2");
        });
    }
}
