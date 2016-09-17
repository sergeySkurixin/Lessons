package ru.sbt.javaschool.lesson2;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class ThreadingMain {
    public static void main(String[] args) throws InterruptedException {
        Test testTask = new Test();
        new Thread(testTask).start();
        Thread.sleep(3000);
        testTask.end();
        System.out.println("URA");

    }

}
