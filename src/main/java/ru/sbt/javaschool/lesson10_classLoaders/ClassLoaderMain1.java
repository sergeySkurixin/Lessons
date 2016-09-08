package ru.sbt.javaschool.lesson10_classLoaders;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * Created by скурихин on 08.09.2016.
 */
public class ClassLoaderMain1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
//        Person person = new Person();
//        Object obj = ClassLoaderMain.class.getClassLoader()
//                .loadClass("ru.sbt.javaschool.lesson10_classLoaders.Person").newInstance();
//        Person person1 = (Person) obj;
        MyClassLoader urlClassLoader = new MyClassLoader(new URL[]{new URL("file:///D:/tmp/")});
        Object obj1 = urlClassLoader.loadClass("ru.sbt.javaschool.lesson10_classLoaders.CalculatorImpl").newInstance();
        Calculator calculator = (Calculator) obj1;
        System.out.println(calculator.add(2, 3));


    }

    static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
            super(urls, parent, factory);
        }

    }
}
