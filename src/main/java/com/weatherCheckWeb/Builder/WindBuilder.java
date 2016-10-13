package com.weatherCheckWeb.Builder;

import com.weatherCheckWeb.Domain.Wind;

/**
 * Created by MaxPower on 04/10/2016.
 */
public final class WindBuilder {
    private float speed;
    private float direction;

    private WindBuilder() {
    }

    public static WindBuilder aWind() {
        return new WindBuilder();
    }

    public WindBuilder withSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public WindBuilder withDirection(float direction) {
        this.direction = direction;
        return this;
    }

    public Wind build() {
        Wind wind = new Wind();
        wind.setSpeed(speed);
        wind.setDirection(direction);
        return wind;
    }
}
