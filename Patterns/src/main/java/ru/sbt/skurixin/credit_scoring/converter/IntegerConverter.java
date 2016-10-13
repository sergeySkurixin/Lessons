package ru.sbt.skurixin.credit_scoring.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SBTJavastudent on 13.10.2016.
 */
public class IntegerConverter implements ConverterTo<Integer> {
    private Map<Class, ConverterValue> converters = new HashMap<>();

    @Override
    public Integer convert(Object valueFrom) {
        ConverterValue converterValue = converters.get(valueFrom.getClass());
        return converterValue.convert(valueFrom);
    }
}
