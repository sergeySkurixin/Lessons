package ru.sbt;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by скурихин on 01.09.2016.
 */
public class CalculatorTest {
    @Test
    public void testPlus() throws Exception {
        Calculator calculator = new Calculator();
        Assert.assertEquals(5, calculator.plus(2, 3));
    }
}
