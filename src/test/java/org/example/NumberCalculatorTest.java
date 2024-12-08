package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NumberCalculatorTest {
    private static NumberCalculator calculator;

    @BeforeAll
    static void setup(){
        calculator = new NumberCalculator();
    }

    @Tag("DEV")
    @Test
    public void testAddingPositiveNumbers() {
        Number actual = calculator.add(1, 2);
        Assertions.assertEquals(3, actual.intValue());
    }

    @Tag("DEV")
    @Test
    public void testAddingNegativeNumbers() {
        Number actual = calculator.add(-1, 2);
        Assertions.assertEquals(1, actual.intValue());
    }

    @Tag("DEV")
    @Test
    public void testSubtractingPositiveNumbers() {
        Number actual = calculator.subtract(1, 2);
        Assertions.assertEquals(-1, actual.intValue());
    }

    @Tag("DEV")
    @Test
    public void testSubtractingNegativeNumbers() {
        Number actual = calculator.subtract(-1, -2);
        Assertions.assertEquals(1, actual.intValue());
    }

    @Tag("DEV")
    @Test
    public void testMultiplyingPositiveNumbers() {
        Number actual = calculator.multiply(2, 10);
        Assertions.assertEquals(20, actual.intValue());
    }

    @Tag("DEV")
    @Test
    public void testMultiplyingNegativeNumbers() {
        Number actual = calculator.multiply(-10, 2);
        Assertions.assertEquals(-20, actual.intValue());
    }

    @Tag("DEV")
    @Test
    public void testDividingPositiveNumbers() {
        Number actual = calculator.divide(1.0, 2.0);
        Assertions.assertEquals(0.5, actual.doubleValue(), 0.001);
    }

    @Tag("DEV")
    @Test
    public void testDividingNegativeNumbers() {
        Number actual = calculator.divide(-1, 2);
        Assertions.assertEquals(-0.5, actual.doubleValue(), 0.001);
    }

    @Tag("DEV")
    @Test
    public void testDividingZeroShouldThrowException() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(-1, 0);
        });
        String expectedMessage = "Divide by zero";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
