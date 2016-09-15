package ru.sbt.javaschool.lesson12_threads.thread1;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class PriorityTestMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new PriorityTest());
            t.setPriority(i%2==0 ?  Thread.MAX_PRIORITY:Thread.MIN_PRIORITY);
        }
    }
}
