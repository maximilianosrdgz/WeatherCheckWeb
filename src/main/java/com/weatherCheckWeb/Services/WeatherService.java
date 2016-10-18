package com.weatherCheckWeb.Services;

import com.weatherCheckWeb.Domain.Forecast;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by MaxPower on 17/10/2016.
 */
@Component
public class WeatherService {

    //Si no anda puede ser por la \
    private static final String URL_START = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"";
    private static final String URL_MID = "%2C%20";
    private static final String URL_END = "\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    @Autowired
    public Proxy proxy;
    private OkHttpClient client = new OkHttpClient();

    //select * from weather.forecast where woeid in (select woeid from geo.places(1) where text="nome, ak")

    public String getYahooWeatherJson(String city, String region) throws IOException{
        String finalUrl = URL_START + city + URL_MID + region + URL_END;
        //Call OKHTTP ---> Arroja Response, dentro de Response hay un String grandote con el JSON

        Request request = new Request.Builder()
                .url(finalUrl)
                .build();
        Response response = client.newCall(request).execute();

        String jsonString = response.body().string();

        JSONObject jsonObject = new JSONObject(jsonString);

        String forecast;

        return city;
        //proxy.mapForecast(jsonObject);

        //Document doc = Jsoup.connect()
        //La lib lo parsea y me devuelve un objeto de la librería JSUP ponele

        //proxy.mapForecast(doc); ---> Devuelve Forecast
        //saveWeather(proxy.mapForecast(doc));
    }

    public void saveWeather(Forecast forecast){
        //Otro método que invoque a los DAO a partir del Forecast que devuelve proxy.mapForecast(JSUP);
    }


}
