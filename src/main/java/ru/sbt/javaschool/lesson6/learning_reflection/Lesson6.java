package ru.sbt.javaschool.lesson6.learning_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by скурихин on 20.08.2016.
 */
public class Lesson6 {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
//        Constructor<String> constructor = String.class.getConstructor();
//        Class<String> c = String.class;
//        Constructor<?>[] constructors = String.class.getConstructors();
//        Method[] methods = String.class.getMethods();
////        for (Method method : methods) {
////            System.out.println(method);
////        }
//        c.getConstructors();
//        c.getDeclaredConstructor();
//  /*      for (Constructor constructor1 : constructors) {
//            System.out.println(constructor1);
//        }*/


        //printConstructors(Test.class);
        //printMethods(Test.class);
//        printSuperClasses(Test.class);
        printFields(GrandParentClassTest.class);

        Class.forName("Test");
        Test.class.getPackage();

    }

    private static void printFields(Class<GrandParentClassTest> testClass) {
        //System.out.println(testClass.getDeclaredFields());
        for (Field field : testClass.getDeclaredFields()) {
            System.out.println(field);
            System.out.println(field.getModifiers());

        }
    }

    private static void printSuperClasses(Class<?> testClass) {
        Class<?> curr = testClass;
        while (curr != null) {
            System.out.println(curr.getSuperclass());
            curr = curr.getSuperclass();
        }
    }


    private static void printMethods(Class<Test> testClass) {
        for (Method method : testClass.getDeclaredMethods()) {
            System.out.println(method);
            method.getReturnType();
        }

        int modifiers = testClass.getModifiers();       // в каждом бите закодировано значение
        boolean aPublic = Modifier.isPublic(modifiers);
        System.out.println(modifiers);
        System.out.println(aPublic);
        //testClass.getDeclaredMethod("asdd").getReturnType();
    }

    public static class GrandParentClassTest<T> {

        public int add(int a, int b) {
            return a + b;
        }

        private String fio;

        public GrandParentClassTest(String FIO) {
            this.fio = FIO;
        }

        public GrandParentClassTest() {
        }
    }

    public static class ParentClassTest<T> extends GrandParentClassTest {
        public ParentClassTest(String name) {
            super(name);
        }
    }

    public static class Test<T extends ParentClassTest<String>> extends ParentClassTest {
        public Test(String name) {

            super(name);
        }

    }

    static void printConstructors(Class<Test> testClass) {
        for (Object testClas : testClass.getConstructors()) {
            System.out.println(testClas);
        }
    }


}
