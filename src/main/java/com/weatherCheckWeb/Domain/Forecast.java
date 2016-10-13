package com.weatherCheckWeb.Domain;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Forecast {

    private Atmosphere atmosphere;
    private Day day;
    private ExtendedForecast extendedForecast;
    private Location location;
    private Wind wind;

    public Forecast(){
    }

    public Forecast(Atmosphere atmosphere, Day day, ExtendedForecast extendedForecast, Location location, Wind wind) {
        this.atmosphere = atmosphere;
        this.day = day;
        this.extendedForecast = extendedForecast;
        this.location = location;
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public ExtendedForecast getExtendedForecast() {
        return extendedForecast;
    }

    public void setExtendedForecast(ExtendedForecast extendedForecast) {
        this.extendedForecast = extendedForecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString(){
        return "Forecast: "+atmosphere.toString()+
                "\nCurrent Day: "+ day.toString()+
                "\nExtended Forecast: "+extendedForecast.toString()+
                "\nLocation: "+location.toString()+
                "\nWind: "+wind.toString();
    }
}
