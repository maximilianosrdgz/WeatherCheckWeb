package com.weatherCheckWeb.Domain;

import java.util.Date;

/**
 * Created by MaxPower on 24/09/2016.
 */
public class Day {

    private String day;
    private Date date;
    private float maxTemp;
    private float minTemp;
    private String description;

    public Day(){
        day = "";
        date = null;
        maxTemp = 0;
        minTemp = 0;
        description = "";
    }

    public Day(String day, Date date, float maxTemp, float minTemp, String description) {
        this.day = day;
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.description = description;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Day: "+day.toString()+
                "\nDate: "+date.toString()+
                "\nMax Temperature: "+maxTemp+
                "\nMin Temperature: "+minTemp+
                "\nDescription: "+description;
    }



}
