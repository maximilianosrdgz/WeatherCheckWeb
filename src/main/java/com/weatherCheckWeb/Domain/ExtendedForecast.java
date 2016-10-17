package com.weatherCheckWeb.Domain;

import java.util.ArrayList;

/**
 * Created by MaxPower on 24/09/2016.
 */
public class ExtendedForecast {

    private ArrayList extForecast;

    public ExtendedForecast(){
    }

    public ExtendedForecast(ArrayList<Day> extForecast) {
        this.extForecast = extForecast;
    }

    public ArrayList getExtForecast() {
        return extForecast;
    }

    public void setExtForecast(ArrayList extForecast) {
        this.extForecast = extForecast;
    }

    @Override
    public String toString(){
        return "Extended forecast: "+extForecast.toString();
    }
}
