package com.gizcompony.prototype.models_adapters;

import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable {

    private Date date ;
    private String title ;
    private String details ;
    private String address ;
    private long lng;
    private long lat ;

    public Complaint(Date date, String title, String details, String address, long lng, long lat) {
        this.date = date;
        this.title = title;
        this.details = details;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
    }

    public Complaint() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }
}
