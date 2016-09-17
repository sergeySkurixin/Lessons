package ru.sbt.javaschool.lesson2;

import com.sun.deploy.security.ruleset.RunRule;

import java.util.concurrent.TimeUnit;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class Test implements Runnable {
    private volatile boolean endFlag;
//    private Object lock = new Object();

    public void end() {
//        synchronized (lock) {
            endFlag = true;
//        }
    }

    @Override
    public void run() {
        double count = 0;
        while (!endFlag) {
//            synchronized (lock) {
                for (int i = 0; i < 1000000; i++) {
                    count = count * Math.PI;
                }
//            }
        }
        System.out.println("STOPPED");
    }
}
