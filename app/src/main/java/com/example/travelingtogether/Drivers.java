package com.example.travelingtogether;

public class Drivers {
    private String name;
    private int freeSeats;
    private int price;
    private int imageId;

    public Drivers(String name, int freeSeats, int price, int imageId) {
        this.name = name;
        this.freeSeats = freeSeats;
        this.price = price;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public int getPrice() {
        return price;
    }

    public int getImageId() {
        return imageId;
    }
}
