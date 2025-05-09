package com.duong.ss04;


public class Hw09_Seat {
    private String code;
    private String name;
    private double price;
    private boolean booked;

    public Hw09_Seat(String code, String name, double price, boolean booked) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.booked = booked;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }
}
