package ru.sbt.skurixin.credit_scoring.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SBTJavastudent on 13.10.2016.
 */
public class ConverterImpl implements Converter {
    private Map<Class, ConverterTo> converters = new HashMap<>();

    @Override
    public <T> T convert(Object valueFrom, Class<T> resultClass) {
        ConverterTo<T> converterTo = converters.get(resultClass);
        return converterTo.convert(valueFrom);
    }

    @Override
    public <T> void addConverterTo(Class<T> resultClass, ConverterTo converterTo) {

    }

    @Override
    public <T> void removeConverterTo(Class<T> resultClass, ConverterTo converterTo) {
        converters.remove(resultClass);
    }
}
