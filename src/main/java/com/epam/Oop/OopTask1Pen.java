package com.epam.Oop;

public class OopTask1Pen extends OfficeSupplies {
    private double cost;
    private String name;
    private String color;
    private int capacity;

    public OopTask1Pen(String name) {
        this.name = name;
    }

    public OopTask1Pen(double cost, String name, String color, int capacity) {
        this.cost = cost;
        this.name = name;
        this.color = color;
        this.capacity = capacity;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public OopTask1Pen(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        OopTask1Pen that = (OopTask1Pen) o;

        if (capacity != that.capacity) return false;
        if (!name.equals(that.name)) return false;
        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        return "OopTask1Pen{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
