package com.duong.ss04;

public class Hw06_Student {
    private String id;
    private String name;
    private int age;
    private double gpa;

    public Hw06_Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}
