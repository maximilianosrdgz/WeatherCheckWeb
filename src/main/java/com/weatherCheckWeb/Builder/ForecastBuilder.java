package com.weatherCheckWeb.Builder;

import com.weatherCheckWeb.Domain.*;

/**
 * Created by MaxPower on 04/10/2016.
 */
public final class ForecastBuilder {
    private Atmosphere atmosphere;
    private Day day;
    private ExtendedForecast extendedForecast;
    private Location location;
    private Wind wind;

    private ForecastBuilder() {
    }

    public static ForecastBuilder aForecast() {
        return new ForecastBuilder();
    }

    public ForecastBuilder withAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
        return this;
    }

    public ForecastBuilder withDay(Day day) {
        this.day = day;
        return this;
    }

    public ForecastBuilder withExtendedForecast(ExtendedForecast extendedForecast) {
        this.extendedForecast = extendedForecast;
        return this;
    }

    public ForecastBuilder withLocation(Location location) {
        this.location = location;
        return this;
    }

    public ForecastBuilder withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    public Forecast build() {
        Forecast forecast = new Forecast();
        forecast.setAtmosphere(atmosphere);
        forecast.setDay(day);
        forecast.setExtendedForecast(extendedForecast);
        forecast.setLocation(location);
        forecast.setWind(wind);
        return forecast;
    }
}
