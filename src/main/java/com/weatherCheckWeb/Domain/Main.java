package com.weatherCheckWeb.Domain;

import com.weatherCheckWeb.Builder.*;
import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.DataAccess.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Main {


    public static void main(String [] args) {

        //Esto es lo que vi en el ejemplo que me mostraron el miercoles, lo cambiepara que tenga el nombre de mi Beans.xml
        //y el id del bean, pero si lo pongo no anda. Compila pero cuando ejecuta arroja muchos errores. Tampoco se si va aca:
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
        //MySQLConnection mySQLCon = (MySQLConnection)context.getBean("mySQLConnection"); //Ya probé con y sin esta línea

        //MySQLConnection mySQLCon;
        Connection con;
        Statement stmtSelect;
        Statement stmtCount;
        int recordCount = 0;


        //Object Forecast variables
        Forecast forec;
        Atmosphere atm;
        Day da;
        ExtendedForecast extForec;
        Location loc;
        Wind win;

        String desc, count, cit, reg;
        float hum, pres, vis, maxT, minT, spd, dir;
        ArrayList<Day> extF = new ArrayList<Day>(10);
        String d;
        String dt;
        Calendar cal = Calendar.getInstance();

        //OBJECTS CREATION

        Scanner scannIn = new Scanner(System.in);

        //Location
        System.out.println("Region: ");
        reg = scannIn.nextLine();
        System.out.println("Country: ");
        count = scannIn.nextLine();
        System.out.println("City: ");
        cit = scannIn.nextLine();

        //Atmosphere
        System.out.println("Humidity: ");
        hum = scannIn.nextFloat();
        System.out.println("Preassure: ");
        pres = scannIn.nextFloat();
        System.out.println("Visibility: ");
        vis = scannIn.nextFloat();

        //Day
        System.out.println("Day of the Week: ");
        System.out.println("Friday");
        d = "friday";
        System.out.println("Date: Today");
        dt = cal.getTime().toString();
        System.out.println("Max Temp: ");
        maxT = scannIn.nextFloat();
        System.out.println("Min Temp: ");
        minT = scannIn.nextFloat();
        System.out.println("Day description: sunny");
        desc = "sunny";
        System.out.println("Ext Forec Init");

        //Ext Forecast
        for (int i=0; i>10; i++){
            extF.add(new Day());
        }

        //Wind
        System.out.println("Wind speed: ");
        spd = scannIn.nextFloat();
        System.out.println("Wind direction: ");
        dir = scannIn.nextFloat();

        //Object Build with Builders
        atm = AtmosphereBuilder.anAtmosphere()
                .withHumidity(hum)
                .withPressure(pres)
                .withVisibility(vis)
                .build();
        da = DayBuilder.aDay()
                .withDate(dt)
                .withDay(d)
                .withDescription(desc)
                .withMaxTemp(maxT)
                .withMinTemp(minT)
                .build();
        loc = LocationBuilder.aLocation()
                .withCity(cit)
                .withCountry(count)
                .withRegion(reg)
                .build();
        extForec = ExtendedForecastBuilder.anExtendedForecast()
                .withExtForecast(extF)
                .build();
        win = WindBuilder.aWind()
                .withDirection(dir)
                .withSpeed(spd)
                .build();

        forec = ForecastBuilder.aForecast()
                .withAtmosphere(atm)
                .withDay(da)
                .withExtendedForecast(extForec)
                .withLocation(loc)
                .withWind(win)
                .build();


        try {


            //Open connection without Spring
            /*
            System.out.println("Flag 1 Connecting");
            MySQLConnection mySQLCon = MySQLConnection.getInstance();
            con = mySQLCon.getCon();

            stmtCount = mySQLCon.getCon().createStatement();
            System.out.println("Statement created");
            String selCount;
            selCount = "select count(*) 'recordCount' from Forecasts";
            ResultSet rsCount = stmtCount.executeQuery(selCount);
            System.out.println("Statement executed");

            while (rsCount.next()) {

                recordCount = rsCount.getInt("recordCount");

                //Output
                System.out.println("Record Count: " + recordCount);

            }
            recordCount++;

            rsCount.close();
            stmtCount.close();*/

            //recordCount hardcodeado
            recordCount = 3;

            //DAO Saves
            //LocationDAO locDAO = new LocationDAO();
            //LocationDAO locationDAO = (LocationDAO)context.getBean("locationDAO");
            //locationDAO.save(forec.getLocation(), recordCount);

            System.out.println("Record Count: " + recordCount);

            //DayDAO dDao = new DayDAO();
            //DayDAO dayDAO = (DayDAO)context.getBean("dayDAO");
            //dayDAO.save(forec.getDay(), recordCount);

            System.out.println("Record Count: " + recordCount);

            //AtmosphereDAO atmosDAO = new AtmosphereDAO();
            //AtmosphereDAO atmosphereDAO = (AtmosphereDAO)context.getBean("atmosphereDAO");
            //atmosphereDAO.save(forec.getAtmosphere(), recordCount);

            System.out.println("Record Count: " + recordCount);

            //WindDAO windDAO = new WindDAO();
            //WindDAO windDAO = (WindDAO)context.getBean("windDAO");
            //windDAO.save(forec.getWind(), recordCount);

            //ForecastDAO foreDAO = new ForecastDAO();
            //ForecastDAO forecastDAO = (ForecastDAO)context.getBean("forecastDAO");
            //forecastDAO.save(forec, recordCount);

            //ExtendedForecastDAO extForeDAO = new ExtendedForecastDAO();
            //ExtendedForecastDAO extendedForecastDAO = (ExtendedForecastDAO)context.getBean("extendedForecastDAO");
            //extendedForecastDAO.save(forec.getExtendedForecast(), recordCount);

        }
        catch(Exception e){

        }
        System.out.println("Flag 3 End");
    }

    }