package ru.sbt.javaschool.lesson10_classLoaders;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * Created by скурихин on 08.09.2016.
 */
public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
//        Person person = new Person();
//        Object obj = ClassLoaderMain.class.getClassLoader()
//                .loadClass("ru.sbt.javaschool.lesson10_classLoaders.Person").newInstance();
//        Person person1 = (Person) obj;
        MyClassLoader urlClassLoader = new MyClassLoader(new URL[]{new URL("file:///D:/root_for_java_classes/")});
        Object obj1 = urlClassLoader.loadClass("ru.sbt.javaschool.lesson10_classLoaders.Person").newInstance();
//        Person person2 = (Person) obj1;

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

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if ("ru.sbt.javaschool.lesson10_classLoaders.Person".equals(name)) {
                return findClass(name);
            }
            else{
                return super.loadClass(name);
            }
        }

    }
}
