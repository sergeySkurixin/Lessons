package ru.sbt.javaschool.lesson12_threads.thread1;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class DaemonMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonExample());
        t.setDaemon(true);
        t.start();


//        TimeUnit.SECONDS.sleep(5);
        System.out.println("Daemon thread has been started.");
    }
}
