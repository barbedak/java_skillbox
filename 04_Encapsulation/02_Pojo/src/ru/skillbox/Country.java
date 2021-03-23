package ru.skillbox;

public class Country {
    private String name;
    private int population;
    private double area;
    private String capital;
    private boolean isAccessSea;

    public Country(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public boolean isAccessSea() {
        return isAccessSea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setAccessSea(boolean accessSea) {
        isAccessSea = accessSea;
    }
}
