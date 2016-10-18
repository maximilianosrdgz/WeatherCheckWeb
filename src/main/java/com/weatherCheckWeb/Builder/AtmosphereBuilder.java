package com.weatherCheckWeb.Builder;

import com.weatherCheckWeb.Domain.Atmosphere;

/**
 * Created by MaxPower on 04/10/2016.
 */
public final class AtmosphereBuilder {
    private float humidity;
    private float pressure;
    private float visibility;

    private AtmosphereBuilder() {
    }

    public static AtmosphereBuilder anAtmosphere() {
        return new AtmosphereBuilder();
    }

    public AtmosphereBuilder withHumidity(float humidity) {
        this.humidity = humidity;
        return this;
    }

    public AtmosphereBuilder withPressure(float pressure) {
        this.pressure = pressure;
        return this;
    }

    public AtmosphereBuilder withVisibility(float visibility) {
        this.visibility = visibility;
        return this;
    }

    public Atmosphere build() {                   //@Autowired
        Atmosphere atmosphere = new Atmosphere(); //Atmosphere atmosphere
        atmosphere.setHumidity(humidity);
        atmosphere.setPressure(pressure);
        atmosphere.setVisibility(visibility);
        return atmosphere;
    }
}
