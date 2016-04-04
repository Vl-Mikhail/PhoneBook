package ru.misha.model;


public class City {

    private int uid;
    private String city;

    public City() {
    }

    public City(int uid) {
        this.uid = uid;
    }

    public City(int uid, String city) {
        this.uid = uid;
        this.city = city;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
