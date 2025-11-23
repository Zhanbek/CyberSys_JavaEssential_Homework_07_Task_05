package model;

import java.util.Scanner;

public class Calculator {
    static double add(double a, double b){
        return a + b;
    }
    static double sub(double a, double b){
        return a - b;
    }
    static double mul(double a, double b){
        return a * b;
    }
    static double div(double a, double b) throws DivideByZero {
        if (b == 0){
            throw new DivideByZero();
        }
        return a / b;
    }

    public static double inputOperand(Scanner input, String numberOfOperandAsText) {
        String valueAsString;
        double value = 0.00;
        boolean isNotValid = true;
        while (isNotValid) {
            try {
                System.out.print("Вкажіть значення " + numberOfOperandAsText + " операнда: ");
                valueAsString = input.nextLine();
                value = Double.parseDouble(valueAsString);
                isNotValid = false;
            } catch (NumberFormatException e) {
                System.out.println("Невірний формат значення " + numberOfOperandAsText + " операнда! Коректний формат \"999999.99\"! Спробуйте ще раз.");
                isNotValid = true;
            }
        }
        return value;
    }

    public static String inputOperation(Scanner input) throws IllegalArgumentException {
        System.out.print("Вкажіть операцію для виконання (+,-,*,/): ");
        String value =  input.nextLine();
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Операція не може бути порожньою! Спробуйте ще раз.");
        }
        return value;
    }

    public static double calculate(double a, double b, String operation) throws IncorrectOperation, DivideByZero {
        double result = 0.00;
        switch (operation) {
            case "+":
                result = add(a, b);
                break;
            case  "-":
                result = sub(a, b);
                break;
            case "*":
                result = mul(a, b);
                break;
            case  "/":
                result = div(a, b);
                break;
            default:
                throw new IncorrectOperation("Операція '" + operation + "' відсутня в списку допустимих!");
        }
        return result;
    }
}
