package org.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

public class NumberCalculatorTest extends TestCase {
    private final NumberCalculator calculator;

    public NumberCalculatorTest(String testName )
    {
        super( testName );
        calculator = new NumberCalculator();
    }

    public void testAddingPositiveNumbers() {
        Number actual = calculator.add(1, 2);
        assertEquals( 3, actual.intValue());
    }

    public void testAddingNegativeNumbers() {
        Number actual = calculator.add(-1, 2);
        assertEquals(1, actual.intValue());
    }

    public void testSubtractingPositiveNumbers() {
        Number actual = calculator.subtract(1, 2);
        assertEquals(-1, actual.intValue());
    }

    public void testSubtractingNegativeNumbers() {
        Number actual = calculator.subtract(-1, -2);
        assertEquals(1, actual.intValue());
    }

    public void testMultiplyingPositiveNumbers() {
        Number actual = calculator.multiply(2, 10);
        assertEquals(20, actual.intValue());
    }

    public void testMultiplyingNegativeNumbers() {
        Number actual = calculator.multiply(-10, 2);
        assertEquals(-20, actual.intValue());
    }

    public void testDividingPositiveNumbers() {
        Number actual = calculator.divide(1.0, 2.0);
        assertEquals(0.5, actual.doubleValue(), 0.001);
    }

    public void testDividingNegativeNumbers() {
        Number actual = calculator.divide(-1, 2);
        assertEquals(-0.5, actual.doubleValue(), 0.001);
    }

    public void testDividingZeroShouldThrowException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(-1, 0);
        });
        String expectedMessage = "Divide by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
