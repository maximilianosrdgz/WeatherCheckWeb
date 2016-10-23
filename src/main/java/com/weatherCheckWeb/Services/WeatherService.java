package com.weatherCheckWeb.Services;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.DataAccess.*;
import com.weatherCheckWeb.Domain.Forecast;
import com.weatherCheckWeb.WeatherProxy.ForecastProxy;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MaxPower on 17/10/2016.
 */
@Component
public class WeatherService {

    private static final String URL_START = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"";
    private static final String URL_MID = "%2C%20";
    private static final String URL_END = "\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    @Autowired
    private ForecastProxy forecastProxy;
    private OkHttpClient client = new OkHttpClient();

    @Autowired
    private MySQLConnection mySQLConnection;

    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private DayDAO dayDAO;
    @Autowired
    private AtmosphereDAO atmosphereDAO;
    @Autowired
    private WindDAO windDAO;
    @Autowired
    private ForecastDAO forecastDAO;
    @Autowired
    private ExtendedForecastDAO extendedForecastDAO;


    public String getYahooWeatherJson(String city, String region) throws IOException{
        //Build the URL with the arguments
        String finalUrl = URL_START + city + URL_MID + region + URL_END;

        //Get response from Yahoo endpoint
        Request request = new Request.Builder()
                .url(finalUrl)
                .build();
        Response response = client.newCall(request).execute();

        String jsonString = response.body().string();

        //Creates JSONObject with the JSON in String taken from the body of the response
        JSONObject jsonObject = new JSONObject(jsonString);

        //Transform JSONObject into Forecast with ForecastProxy Class
        Forecast forecast = forecastProxy.mapForecast(jsonObject);

        String stringForecast = forecast.toString();

        //DAO call
        saveWeather(forecast);

        //Prints Forecast info on screen
        return stringForecast;
    }

    public void saveWeather(Forecast forecast){

        int recordCount = getRecordCount() + 1;

        locationDAO.save(forecast.getLocation(), recordCount);

        dayDAO.save(forecast.getDay(), recordCount);

        atmosphereDAO.save(forecast.getAtmosphere(), recordCount);

        windDAO.save(forecast.getWind(), recordCount);

        forecastDAO.save(forecast, recordCount);

        extendedForecastDAO.save(forecast.getExtendedForecast(), recordCount);

        /*
        try {
            mySQLConnection.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    //Gets the current number of forecasts recorded in the DB
    public int getRecordCount(){

        int recordCount = 0;

        try {

            Statement stmtCount = mySQLConnection.getCon().createStatement();
            String selCount = "select count(*) 'recordCount' from Forecasts";
            ResultSet rsCount = stmtCount.executeQuery(selCount);
            while(rsCount.next()){
                recordCount = rsCount.getInt("recordCount");
            }
            rsCount.close();
            stmtCount.close();
        }

        catch(Exception e){
        }

        return recordCount;
    }


}
