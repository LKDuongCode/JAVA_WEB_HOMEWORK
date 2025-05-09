package com.duong.ss04;


public class Hw07_Product {
    private String id;
    private String name;
    private double price;

    public Hw07_Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
