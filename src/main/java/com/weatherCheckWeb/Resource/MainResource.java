package com.weatherCheckWeb.Resource;

import com.weatherCheckWeb.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Created by MaxPower on 15/10/2016.
 */
@Component
@Path("/weather")
public class MainResource {

    @Autowired
    private WeatherService weatherService;

    @GET
    @Path("/getWeather/{city}/{region}")
    @Produces("text/plain")
    public String getWeather(@PathParam("city") String city, @PathParam("region") String region) throws IOException {

        return weatherService.getYahooWeatherJson(city, region);

    }

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String echo(@PathParam("input") String input) {
        return input;
    }

    /*
    1. Mi endpoint toma el parametro city y se lo pasa a un service
    2. Dentro de service llamo al endpoint de Yahoo con OKHTTP
    3. Lo que me devuelve se lo paso al proxy
    3. Mi proxy va tomando los datos del JSON con alguna lib JSUP (se agrega al pom), lo transforma
        a mis objetos modelados y los guarda en la DB

    ------------------PREGUNTAR EN DAILY------------------
    Usar @Autowired en Builders?
    Jackson?
    Client Interface?
    */

}
