package ru.sbt.javaschool.lesson2.example3;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class ExampleMain {
    public static void main(String[] args) throws IOException {
        Object lock = new Object();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new HardWork(lock));
            thread.start();
            threads.add(thread);

        }
        System.out.println("Enter to start");
        int read = System.in.read();
        System.out.println(read);
        if(read==50){
            threads.stream()
                    .forEach(Thread::interrupt);
        }
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("OUT!");
    }
}
