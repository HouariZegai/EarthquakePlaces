package com.houarizegai.placefinder.model;

public class AdminCodes1 {
    private String ISO3166_2;

    public AdminCodes1() {
    }

    public AdminCodes1(String ISO3166_2) {
        this.ISO3166_2 = ISO3166_2;
    }

    public String getISO3166_2() {
        return ISO3166_2;
    }

    public void setISO3166_2(String ISO3166_2) {
        this.ISO3166_2 = ISO3166_2;
    }

    @Override
    public String toString() {
        return "AdminCodes1{" +
                "ISO3166_2='" + ISO3166_2 + '\'' +
                '}';
    }
}
