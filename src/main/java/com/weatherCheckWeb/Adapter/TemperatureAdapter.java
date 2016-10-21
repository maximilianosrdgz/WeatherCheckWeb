package com.weatherCheckWeb.Adapter;

import org.springframework.stereotype.Component;

/**
 * Created by MaxPower on 21/10/2016.
 */
@Component
public class TemperatureAdapter extends CelsiusTemperature {


    public float getCelsiusTemperature() {
        return celsiusTemperature;
    }


    public float getFahrenheitTemperature() {
        return celToFah(celsiusTemperature);
    }


    public void setCelciusTemperature(float celsiusTemperature) {
        this.celsiusTemperature = celsiusTemperature;
    }


    public void setFahrenheitTemperature(float fahrenheitTemperature) {
        this.celsiusTemperature = fahToCel(fahrenheitTemperature);
    }

    private float fahToCel(float f) {
        return ((f - 32) * 5 / 9);
    }

    private float celToFah(float c) {
        return ((c * 9 / 5) + 32);
    }

}
