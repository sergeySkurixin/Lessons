package ru.sbt.javaschool.lesson6.annotation;

import java.lang.reflect.InvocationHandler;

/**
 * Created by скурихин on 27.08.2016.
 */


public class Lesson6B {
    public static void main(String[] args) throws Exception {
        Truck truck = new Truck(1, "MERCEDESS", 500);
        new A().print(truck);

    }
}
