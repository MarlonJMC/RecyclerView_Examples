package com.example.recyclerview;

public class Product {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String QUANTITY = "quantity";
    public static final String PHOTO_URL = "photoUrl";

    private String id;
    private String name;
    private int quantity;
    private String photoUrl;

    public Product() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


}
