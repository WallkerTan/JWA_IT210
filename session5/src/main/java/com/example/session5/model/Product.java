package com.example.session5.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, double price, int stock, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isStatus() {
        return status;
    }
}
