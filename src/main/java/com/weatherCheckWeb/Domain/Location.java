package com.weatherCheckWeb.Domain;

import java.time.LocalTime;

/**
 * Created by MaxPower on 24/09/2016.
 */
public class Location {

    private String country;
    private String city;
    private String region;

    public Location(){
    }

    public Location(String city, String country, String region){
        this.city=city;
        this.country=country;
        this.region=region;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString(){
        return "City: "+city+
                "\nCountry: "+country+
                "\nRegion: "+region;
    }
}
