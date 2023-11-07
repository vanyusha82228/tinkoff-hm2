package edu.hm3.task6;

public class Stock {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "Stock{"
            + "name='" + name + '\''
            + ", price=" + price
            + '}';
    }
}
