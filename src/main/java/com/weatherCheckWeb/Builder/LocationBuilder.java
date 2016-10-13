package com.weatherCheckWeb.Builder;

import com.weatherCheckWeb.Domain.Location;

/**
 * Created by MaxPower on 04/10/2016.
 */
public final class LocationBuilder {
    private String country;
    private String city;
    private String region;

    private LocationBuilder() {
    }

    public static LocationBuilder aLocation() {
        return new LocationBuilder();
    }

    public LocationBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public LocationBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public LocationBuilder withRegion(String region) {
        this.region = region;
        return this;
    }

    public Location build() {
        Location location = new Location();
        location.setCountry(country);
        location.setCity(city);
        location.setRegion(region);
        return location;
    }
}
