package com.houarizegai.placefinder.model;

public class Geoname {
    private String adminCode1;
    private String lng;
    private int geonameId;
    private String toponymName;
    private String countryId;
    private String fcl;
    private String population;
    private String countryCode;
    private String name;
    private String fclName;
    private AdminCodes1 adminCodes1;
    private String countryName;
    private String fcodeName;
    private String adminName1;
    private String lat;
    private String fcode;

    public Geoname() {
    }

    public Geoname(String adminCode1, String lng, int geonameId, String toponymName, String countryId, String fcl, String population, String countryCode, String name, String fclName, String countryName, String fcodeName, String adminName1, String lat, String fcode) {
        this.adminCode1 = adminCode1;
        this.lng = lng;
        this.geonameId = geonameId;
        this.toponymName = toponymName;
        this.countryId = countryId;
        this.fcl = fcl;
        this.population = population;
        this.countryCode = countryCode;
        this.name = name;
        this.fclName = fclName;
        this.countryName = countryName;
        this.fcodeName = fcodeName;
        this.adminName1 = adminName1;
        this.lat = lat;
        this.fcode = fcode;
    }

    public Geoname(String adminCode1, String lng, int geonameId, String toponymName, String countryId, String fcl, String population, String countryCode, String name, String fclName, AdminCodes1 adminCodes1, String countryName, String fcodeName, String adminName1, String lat, String fcode) {
        this.adminCode1 = adminCode1;
        this.lng = lng;
        this.geonameId = geonameId;
        this.countryId = countryId;
        this.toponymName = toponymName;
        this.fcl = fcl;
        this.population = population;
        this.countryCode = countryCode;
        this.name = name;
        this.fclName = fclName;
        this.adminCodes1 = adminCodes1;
        this.countryName = countryName;
        this.fcodeName = fcodeName;
        this.adminName1 = adminName1;
        this.lat = lat;
        this.fcode = fcode;
    }

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public AdminCodes1 getAdminCodes1() {
        return adminCodes1;
    }

    public void setAdminCodes1(AdminCodes1 adminCodes1) {
        this.adminCodes1 = adminCodes1;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    @Override
    public String toString() {
        return "Geoname{" +
                "adminCode1='" + adminCode1 + '\'' +
                ", lng='" + lng + '\'' +
                ", geonameId=" + geonameId +
                ", toponymName='" + toponymName + '\'' +
                ", countryId='" + countryId + '\'' +
                ", fcl='" + fcl + '\'' +
                ", population='" + population + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                ", fclName='" + fclName + '\'' +
                ", adminCodes1=" + adminCodes1 +
                ", countryName='" + countryName + '\'' +
                ", fcodeName='" + fcodeName + '\'' +
                ", adminName1='" + adminName1 + '\'' +
                ", lat='" + lat + '\'' +
                ", fcode='" + fcode + '\'' +
                '}';
    }
}
