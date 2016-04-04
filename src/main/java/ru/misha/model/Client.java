package ru.misha.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    private int uid;
    private String lastname; // Фамилия
    private String firstname;
    private String middlename;
    private City city;
    private Street street;
    private String phonenum;
    private int cityId;
    private int streetId;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date bithday;

    public Client() {
    }

    public Client(int uid, String lastname) {
        this.uid = uid;
        this.lastname = lastname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Date getBithday() {
        return bithday;
    }

    public void setBithday(Date bithday) {
        this.bithday = bithday;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getBithdayValue() {
        return this.bithday != null ? DATE_FORMAT.format(this.bithday) : "";
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetIfd) {
        this.streetId = streetIfd;
    }
}
