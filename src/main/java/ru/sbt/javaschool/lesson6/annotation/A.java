package ru.sbt.javaschool.lesson6.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by скурихин on 27.08.2016.
 */

@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Format {
    /**
     * Formatter class name
     */
    String value();
    /**
     * Имя поля которое надо распечатать
     */
    String filedName() default "SBT School";


    boolean fullDescription() default true;

}

public class A {

    @Format(value = "type",fullDescription = true)
    public void print(Truck truck) throws Exception {
        Method printMethod = A.class.getMethod("print", Truck.class);
        Format annotation = printMethod.getAnnotation(Format.class);

        String fieldName = annotation.filedName();
        Method getterMethod = truck.getClass().getMethod(getGetterNameForField(fieldName));
        Object value = getterMethod.invoke(truck);
        System.out.println("PRINTER:");
        if (value == null) {
            throw new IllegalArgumentException("no value for field:" + fieldName);

        }
        System.out.println(value.toString());
    }

    private String getGetterNameForField(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}

/**
 * <person name='Ivan' phone='123423'>
 *     <children>
 *         <person name='maef' phone='2351'/>
 *         <person name='maef1' phone='23513'/>
 *         <person name='maef2' phone='23512'/>
 *     </children>
 * </person>
 */

@interface Element{String name();};
@interface Attribute{String value() default "";};

@Element(name="person")
class Person{
    @Attribute("name")
    String fillName;
    @Attribute
    String phone;
    @Element(name="children")
    List<Person> children;
}