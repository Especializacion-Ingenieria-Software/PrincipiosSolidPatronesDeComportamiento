package org.example.template_method;

public class BusCalculator extends TravelTimeCalculator {
    
    @Override
    public void calculateTime() {
        double time = this.distance / this.speed + (this.distance / this.speed) * 0.3;
        System.out.println("Tiempo de viaje estimado en Bus: " + time + "Horas");
    }

}
