package ru.misha.model;


public class Street {

    private int uid;
    private String street;
    private int cityId;

    public Street() {
    }

    public Street(int uid) {
        this.uid = uid;
    }

    public Street(int uid, String street) {
        this.uid = uid;
        this.street = street;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
