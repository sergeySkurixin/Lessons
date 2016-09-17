package ru.sbt.javaschool.lesson2.example3;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class HardWork implements Runnable {
    private Object lock;

    public HardWork(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println("CANCEL");
                return;
            }
        }
        System.out.println("HACK!");
    }
}
