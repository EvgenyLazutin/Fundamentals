package com.epam.Oop;

public class OopTask1Pen {
    private String name;
    private String color;
    private int copabilty;

    public OopTask1Pen(String name) {
        this.name = name;
    }

    public OopTask1Pen(String name, String color, int copabilty) {
        this.name = name;
        this.color = color;
        this.copabilty = copabilty;
    }

    public OopTask1Pen(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OopTask1Pen)) return false;

        OopTask1Pen that = (OopTask1Pen) o;

        if (copabilty != that.copabilty) return false;
        if (!name.equals(that.name)) return false;
        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + copabilty;
        return result;
    }

    @Override
    public String toString() {
        return "OopTask1Pen{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", copabilty=" + copabilty +
                '}';
    }
}
