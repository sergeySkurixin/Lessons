package ru.sbt.javaschool.lesson12_threads.thread1;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class ThrowExceptionSimpleCase implements Runnable {

    @Override
    public void run() {
//        try {
//            throw new RuntimeException();
//        }catch (Exception ex){
//            System.out.println("Catch exception");
//        }
        throw new RuntimeException();
    }
}
