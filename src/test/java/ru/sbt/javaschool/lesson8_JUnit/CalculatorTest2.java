package ru.sbt.javaschool.lesson8_JUnit;

import org.junit.*;
import ru.sbt.javaschool.lesson8_JUnit.Calculator;

/**
 * Created by скурихин on 01.09.2016.
 */
public class CalculatorTest2 {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testPlus() throws Exception {
        Calculator calculator = new Calculator();
        Assert.assertEquals(5, calculator.plus(2, 3));
    }

    @Test
    public void testPlus2() throws Exception {
        Calculator calculator = new Calculator();
        Assert.assertEquals(5, calculator.plus(2, 3));
    }
}
