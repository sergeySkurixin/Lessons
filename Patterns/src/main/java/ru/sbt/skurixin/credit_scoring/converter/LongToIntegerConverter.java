package ru.sbt.skurixin.credit_scoring.converter;

/**
 * Created by SBTJavastudent on 13.10.2016.
 */
public class LongToIntegerConverter implements ConverterValue<Integer> {
    @Override
    public Integer convert(Object valueFrom) {
        Long aLong = (Long)valueFrom;
        return aLong.intValue();
    }
}
