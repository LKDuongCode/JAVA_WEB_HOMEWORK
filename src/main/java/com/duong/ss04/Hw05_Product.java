package com.duong.ss04;


public class Hw05_Product {
    private String id;
    private String name;
    private double price;
    private String description;

    public Hw05_Product(String id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
