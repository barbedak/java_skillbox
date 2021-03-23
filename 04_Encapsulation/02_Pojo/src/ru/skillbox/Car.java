package ru.skillbox;

public class Car {
    private double engineVolume;
    private String engineType;
    private int wheelRadius;

    public Car(double engineVolume, String engineType) {
        this.engineVolume = engineVolume;
        this.engineType = engineType;
    }

    public Car(int wheelRadius) {
        this.wheelRadius = wheelRadius;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getWheelRadius() {
        return wheelRadius;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setWheelRadius(int wheelRadius) {
        this.wheelRadius = wheelRadius;
    }
}
