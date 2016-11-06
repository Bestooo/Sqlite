package com.example.marwa.sqlite.model;

/**
 * Created by Marwa on 6/7/2016.
 */
public class Contact {
    private int id;
    private String name;
    private String phone;

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
