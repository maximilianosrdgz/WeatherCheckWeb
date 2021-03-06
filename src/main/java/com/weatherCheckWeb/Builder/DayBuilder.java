package com.weatherCheckWeb.Builder;

import com.weatherCheckWeb.Domain.Day;


/**
 * Created by MaxPower on 04/10/2016.
 */
public final class DayBuilder {
    private String day;
    private String date;
    private float maxTemp;
    private float minTemp;
    private String description;

    private DayBuilder() {
    }

    public static DayBuilder aDay() {
        return new DayBuilder();
    }

    public DayBuilder withDay(String day) {
        this.day = day;
        return this;
    }

    public DayBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public DayBuilder withMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
        return this;
    }

    public DayBuilder withMinTemp(float minTemp) {
        this.minTemp = minTemp;
        return this;
    }

    public DayBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Day build() {
        Day day = new Day();
        day.setDay(this.day);
        day.setDate(date);
        day.setMaxTemp(maxTemp);
        day.setMinTemp(minTemp);
        day.setDescription(description);
        return day;
    }
}
