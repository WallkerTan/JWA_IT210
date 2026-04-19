package com.example.session10.model;

public class Equipment {
    private Long id;
    private String name;
    private String image;
    private int quantity;

    public Equipment() {
    }

    public Equipment(Long id, String name, String image, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
