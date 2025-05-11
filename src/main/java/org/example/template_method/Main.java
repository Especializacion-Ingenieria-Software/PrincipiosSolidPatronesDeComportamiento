package org.example.template_method;

public class Main {

    public static void main(String[] args) {
        TravelTimeCalculator calculator = new MotorcycleCalculator();
        calculator.timeCalculator(50.0, 23.0);
        System.err.println("============================");
        calculator = new BusCalculator();
        calculator.timeCalculator(50.0, 23.0);
    }
}
