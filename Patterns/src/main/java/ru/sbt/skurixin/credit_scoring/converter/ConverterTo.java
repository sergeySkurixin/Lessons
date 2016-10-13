package ru.sbt.skurixin.credit_scoring.converter;

/**
 * Created by SBTJavastudent on 13.10.2016.
 */
public interface ConverterTo <T>{
    T convert(Object valueFrom);
}
