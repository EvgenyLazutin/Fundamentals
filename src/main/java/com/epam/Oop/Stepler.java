package com.epam.Oop;

public class Stepler extends OfficeSupplies {
    private double cost;
    private String name;
    private int width;


    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public Stepler(double cost, String name, int width) {
        this.cost = cost;
        this.name = name;
        this.width = width;

    }
}
