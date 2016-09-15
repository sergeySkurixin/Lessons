package ru.sbt.javaschool.lesson12_threads.thread1;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class DaemonExample implements Runnable {
    public void run(){
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(String.format("#%d(%s)", i, Thread.currentThread().getName()));

            }
        }
        finally {
            System.out.println("Thread has done");
        }
    }
}
