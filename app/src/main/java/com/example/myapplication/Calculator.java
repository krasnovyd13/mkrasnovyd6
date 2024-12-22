package com.example.myapplication;

public class Calculator {

    public double calculate(double valueOne, double valueTwo, String operator) {
        double result;
        switch (operator) {
            case "+":
                result = valueOne + valueTwo;
                break;
            case "-":
                result = valueOne - valueTwo;
                break;
            case "*":
                result = valueOne * valueTwo;
                break;
            case "/":
                if (valueTwo == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = valueOne / valueTwo;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        return result;
    }
}
