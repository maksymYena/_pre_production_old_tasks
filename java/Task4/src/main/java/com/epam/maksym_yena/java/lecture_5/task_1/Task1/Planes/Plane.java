package com.epam.maksym_yena.java.lecture_5.task_1.Task1.Planes;

public abstract class Plane {

    protected String name = "Unknown";
    protected double weight = 0.0;
    protected int maxSpeed = 0;
    protected double fuelConsumption = 0;
    protected int fuelTank = 0;
    protected int carriage = 0;
    protected int maxCapacity = 0;

    protected double getFlghtRange = 0;

    public double getGetFlghtRange() {
        return getFlghtRange;
    }

    public void setGetFlghtRange(double getFlghtRange) {
        this.getFlghtRange = getFlghtRange;
    }

    public abstract double maximumFlight();

    Plane(String name, double weight, int maxSpeed, double fuelConsumption,
          int fuelTank, int carriage, int maxCapacity, int getFlghtRange) {
        this.name = name;
        this.weight = weight;
        this.maxCapacity = maxCapacity;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.fuelTank = fuelTank;
        this.carriage = carriage;
        this.getFlghtRange = getFlghtRange;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public int getCarriage() {
        return carriage;
    }

    public void setCarriage(int carriage) {
        this.carriage = carriage;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }



}
