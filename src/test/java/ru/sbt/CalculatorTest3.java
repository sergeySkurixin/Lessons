package ru.sbt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by скурихин on 01.09.2016.
 */
@RunWith(Parameterized.class)
public class CalculatorTest3 {
    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int expected;
    private Calculator calculator = new Calculator();

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{5, 2, 7}, {1, 1, 2}, {2, 1, 3}});
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(expected, calculator.plus(a, b));
    }
}
