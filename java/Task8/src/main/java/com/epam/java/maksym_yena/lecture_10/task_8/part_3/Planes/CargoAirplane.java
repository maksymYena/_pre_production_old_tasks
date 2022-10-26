package com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes;

import java.io.Serializable;

public class CargoAirplane extends Plane implements Serializable {

    transient private double weigthOfCargo = 0;

    public double getWeigthOfCargo() {
        return weigthOfCargo;
    }

    public void setWeigthOfCargo(double weigthOfCargo) {
        this.weigthOfCargo = weigthOfCargo;
    }

    public CargoAirplane(String name, double weight, int maxSpeed, double fuelConsumption,
                         int fuelTank, int carriage, int maxCapacity, double weigthOfCargo, int getFlghtRange)
    {
        super(name,weight,maxSpeed,fuelConsumption,fuelTank,carriage,maxCapacity, getFlghtRange);
        this.weigthOfCargo = weigthOfCargo;
    }

    @Override
    public String toString() {
        return "CargoAirplane{" +
                "weigthOfCargo=" + weigthOfCargo +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelTank=" + fuelTank +
                ", carriage=" + carriage +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    @Override
    public double maximumFlight() {
        double result = 1;
        int metrToKillometer = 1000;
        if(getWeigthOfCargo()  > getWeight()) {
            result = 0;
            System.out.println("The plane cannot fly! ");
        }
        else {
            result = getWeight() - getWeigthOfCargo();
            System.out.println("The plane can fly! It max height of flight: " + (result / metrToKillometer) + " killometer(s)");
        }
        return result;
    }

}
