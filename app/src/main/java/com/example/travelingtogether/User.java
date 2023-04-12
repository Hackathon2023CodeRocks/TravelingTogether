package com.example.travelingtogether;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private byte[] img;

    public User(int id, String name, String email, String password, byte[] img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getImg() {
        return img;
    }
}

