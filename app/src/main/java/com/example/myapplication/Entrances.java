package com.example.myapplication;

public class Entrances {
    private String fname;
    private String lname;
    private int temperature;
    private String phoneNumber;
    private String email;

    public Entrances(String fname, String lname, int temperature, String phoneNumber, String email) {
        this.fname = fname;
        this.lname = lname;
        this.temperature = temperature;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
