package com.example.hw2application;

public class Contact {
    private String name;
    private String lastname;
    private String number;
    private int imageResourceId;

    public Contact(String name, String lastname, String  number, int imageResourceId) {
        this.name = name;
        this.lastname = lastname;
        this.number = number;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getNumber() {
        return number;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return name;
    }
}
