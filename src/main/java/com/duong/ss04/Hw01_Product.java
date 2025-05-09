package com.duong.ss04;

public class Hw01_Product {
    private int id;
    private String name;
    private double price;
    private String des;

    public Hw01_Product() {
    }


    public Hw01_Product(int id, String name,double price,String des ) {
        this.id = id;
        this.des = des;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
