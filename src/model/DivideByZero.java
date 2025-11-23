package model;

public class DivideByZero extends Exception {
    public DivideByZero() {
        super("Дільник не може бути дорівнює нулю!");
    }
}
