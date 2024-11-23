package org.example;

public class NumberCalculator implements ICalculator {
    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public Number subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public Number multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public Number divide(Number a, Number b) {
        if(b.doubleValue() == 0)
        {
            throw new ArithmeticException("Divide by zero");
        }
        return a.doubleValue() / b.doubleValue();
    }
}
