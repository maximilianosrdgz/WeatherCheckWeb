package com.weatherCheckWeb.Domain;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Wind {

    private float speed;
    private float direction;

    public Wind(){
    }

    public Wind(float speed, float direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return  "Speed: " + speed +
                "\nDirection: "+ direction + "º";
    }
}
