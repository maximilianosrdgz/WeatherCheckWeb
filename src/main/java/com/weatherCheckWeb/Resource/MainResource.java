package com.weatherCheckWeb.Resource;

import com.weatherCheckWeb.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by MaxPower on 15/10/2016.
 */
@Component
@Path("/weather")
public class MainResource {

    @Autowired
    private WeatherService weatherService;

    @GET
    @Path("/getWeather/{city}")
    @Produces("text/plain")
    public void getWeather(@PathParam("city") String city) {

        weatherService.getYahooWeatherJson(city);

    }

    /*
    1. Mi endpoint toma el parametro city y se lo pasa a un service
    2. Dentro de service llamo al endpoint de Yahoo con OKHTTP
    3. Lo que me devuelve se lo paso al proxy
    3. Mi proxy va tomando los datos del JSON con alguna lib JSUP (se agrega al pom), lo transforma
        a mis objetos modelados y los guarda en la DB
    */

}
