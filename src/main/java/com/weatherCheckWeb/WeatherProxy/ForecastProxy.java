package com.weatherCheckWeb.WeatherProxy;

import com.weatherCheckWeb.Adapter.TemperatureAdapter;
import com.weatherCheckWeb.Builder.*;
import com.weatherCheckWeb.Domain.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by MaxPower on 17/10/2016.
 */
@Component
public class ForecastProxy {

    @Autowired
    private TemperatureAdapter temperatureAdapter;

    //Maps JSONObject into Forecast
    public Forecast mapForecast(JSONObject jsonObject){

        Forecast forecast;
        Atmosphere atmosphere;
        Day day = null;
        ExtendedForecast extendedForecast;
        Location location;
        Wind wind;

        String country, city, region;
        float humidity, pressure, visibility, speed, direction, high, low;
        ArrayList<Day> extF = new ArrayList<Day>(10);

        JSONObject jsonQuery = jsonObject.getJSONObject("query");
        JSONObject jsonResults = jsonQuery.getJSONObject("results");
        JSONObject jsonChannel = jsonResults.getJSONObject("channel");
        JSONObject jsonItem = jsonChannel.getJSONObject("item");

        JSONObject jsonLocation = jsonChannel.getJSONObject("location");
        JSONObject jsonWind = jsonChannel.getJSONObject("wind");
        JSONObject jsonAtmosphere = jsonChannel.getJSONObject("atmosphere");
        JSONArray jsonArrayExtendedForecast = jsonItem.getJSONArray("forecast");

        country = jsonLocation.getString("country");
        city = jsonLocation.getString("city");
        region = jsonLocation.getString("region");

        humidity = (float)jsonAtmosphere.getDouble("humidity");
        pressure =(float)jsonAtmosphere.getDouble("pressure");
        visibility = (float)jsonAtmosphere.getDouble("visibility");

        speed = (float)jsonWind.getDouble("speed");
        direction = (float)jsonWind.getDouble("direction");

        for(int i=0; i<10; i++){
            if(i == 0){
                //Adapt temperature to Celsius with Adapter Pattern
                temperatureAdapter.setFahrenheitTemperature(Float.valueOf(jsonArrayExtendedForecast.getJSONObject(i).getString("high")));
                high = temperatureAdapter.getCelsiusTemperature();
                temperatureAdapter.setFahrenheitTemperature(Float.valueOf(jsonArrayExtendedForecast.getJSONObject(i).getString("low")));
                low = temperatureAdapter.getCelsiusTemperature();
                day = DayBuilder.aDay()
                        .withDay(jsonArrayExtendedForecast.getJSONObject(i).getString("day"))
                        .withDate(jsonArrayExtendedForecast.getJSONObject(i).getString("date"))
                        .withDescription(jsonArrayExtendedForecast.getJSONObject(i).getString("text"))
                        .withMaxTemp(high)
                        .withMinTemp(low)
                        .build();
                extF.add(day);
            }
            //Adapt temperature to Celsius with Adapter Pattern
            temperatureAdapter.setFahrenheitTemperature(Float.valueOf(jsonArrayExtendedForecast.getJSONObject(i).getString("high")));
            high = temperatureAdapter.getCelsiusTemperature();
            temperatureAdapter.setFahrenheitTemperature(Float.valueOf(jsonArrayExtendedForecast.getJSONObject(i).getString("low")));
            low = temperatureAdapter.getCelsiusTemperature();
            extF.add(i, DayBuilder.aDay()
                    .withDay(jsonArrayExtendedForecast.getJSONObject(i).getString("day"))
                    .withDate(jsonArrayExtendedForecast.getJSONObject(i).getString("date"))
                    .withDescription(jsonArrayExtendedForecast.getJSONObject(i).getString("text"))
                    .withMaxTemp(high)
                    .withMinTemp(low)
                    .build());
        }

        wind = WindBuilder.aWind()
                .withDirection(direction)
                .withSpeed(speed)
                .build();

        atmosphere = AtmosphereBuilder.anAtmosphere()
                .withHumidity(humidity)
                .withPressure(pressure)
                .withVisibility(visibility)
                .build();

        location = LocationBuilder.aLocation()
                .withCity(city)
                .withCountry(country)
                .withRegion(region)
                .build();

        extendedForecast = ExtendedForecastBuilder.anExtendedForecast()
                .withExtForecast(extF)
                .build();

        forecast = ForecastBuilder.aForecast()
                .withExtendedForecast(extendedForecast)
                .withAtmosphere(atmosphere)
                .withDay(day)
                .withLocation(location)
                .withWind(wind)
                .build();

        return forecast;

    }

}
