package ru.sbt.javaschool.lesson6.learning_reflection;

import java.lang.reflect.*;

/**
 * Created by скурихин on 20.08.2016.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class<?> aClass = Class.forName("ru.sbt.javaschool.lesson6.Lesson6$GrandParentClassTest");
//        System.out.println(aClass);

        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object objGrTest = constructor.newInstance("adsf");
//        System.out.println(objGrTest);

//        Constructor<?> constructor1 = aClass.getConstructor(Lesson6.class, String.class);
//        Object objGrTest = constructor1.newInstance(new Lesson6(),"adasf");

//        Field fio = aClass.getDeclaredField("fio");
//        fio.setAccessible(true);
//        Object value = fio.get(objGrTest);
//        System.out.println(value.toString());
//        fio.set(objGrTest, "Stepan");
//        System.out.println(fio.get(objGrTest));
//
//        Method add = aClass.getMethod("add", int.class,int.class);
//        Object invoke = add.invoke(objGrTest, 2, 2);
//        System.out.println(invoke);


//        TypeVariable<? extends Class<?>> typeParameters = aClass.getTypeParameters()[0];
//        System.out.println(typeParameters.getBounds());

        Class<?> gClass = Class.forName("ru.sbt.javaschool.lesson6.Lesson6$GrandParentClassTest");
        Constructor<?> constructorG = gClass.getConstructor(String.class);
        Object aeaag = constructorG.newInstance("aeaag");

        Type genericSuperclass = gClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
}
