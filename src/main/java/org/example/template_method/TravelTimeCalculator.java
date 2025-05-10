package org.example.template_method;

public abstract class TravelTimeCalculator {

    protected Double speed;
    protected Double distance;

    public void timeCalculator(Double speed, Double distance) {
        System.out.println("Iniciando validaciones");
        this.speed = speed;
        this.distance = distance;
        if(!validateIn()) {
            System.err.println("Entrada erronea");
            return;
        }
        System.out.println("Entrada aceptada");
        this.calculateTime();
    }

    public boolean validateIn() {
        return this.speed >= 0 && this.distance >= 0;  
    }

    public abstract void calculateTime();

}
