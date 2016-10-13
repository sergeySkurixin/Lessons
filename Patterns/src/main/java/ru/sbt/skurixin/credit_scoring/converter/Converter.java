package ru.sbt.skurixin.credit_scoring.converter;

/**
 * Created by SBTJavastudent on 13.10.2016.
 */
public interface Converter {
    //Integer, Float, Double, Long, BigDecimal;
    <T> T convert(Object valueFrom, Class<T> resultClass);

    <T> void addConverterTo(Class<T> resultClass,ConverterTo converterTo);

    <T> void removeConverterTo(Class<T> resultClass, ConverterTo converterTo);
}
