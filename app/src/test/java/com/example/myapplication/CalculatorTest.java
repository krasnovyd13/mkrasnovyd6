package com.example.myapplication;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.calculate(2.0, 3.0, "+"), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(-1.0, calculator.calculate(2.0, 3.0, "-"), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(6.0, calculator.calculate(2.0, 3.0, "*"), 0.001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.calculate(6.0, 3.0, "/"), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.calculate(6.0, 0.0, "/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        calculator.calculate(2.0, 3.0, "%");
    }
}
