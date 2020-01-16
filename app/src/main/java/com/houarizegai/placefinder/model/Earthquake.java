package com.houarizegai.placefinder.model;

public class Earthquake {
    private String datetime;
    private double depth;
    private double lng;
    private String src;
    private String eqid;
    private double magnitude;
    private double lat;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "datetime='" + datetime + '\'' +
                ", depth=" + depth +
                ", lng=" + lng +
                ", src='" + src + '\'' +
                ", eqid='" + eqid + '\'' +
                ", magnitude=" + magnitude +
                ", lat=" + lat +
                '}';
    }
}
