package com.epam.Oop;

public class Proofreader extends OfficeSupplies {
    private double cost;
    private String name;
    private String color;

    public Proofreader(double cost, String name, String color) {
        this.cost = cost;
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
}
