package org.example.template_method;

public class MotorcycleCalculator extends TravelTimeCalculator {
    
    @Override
    public void calculateTime() {
        double time = this.distance / this.speed;
        System.out.println("Tiempo de viaje estimado en moto: " + time + "Horas");
    }

}
