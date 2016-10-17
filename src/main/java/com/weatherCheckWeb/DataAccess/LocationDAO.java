package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
@Repository
public class LocationDAO {

    @Autowired
    MySQLConnection mySQLCon;
    Connection con;

    public void save(Location loc, int recordCount){

        //mySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{

            con = mySQLCon.getCon();
            stmtInsert = con.createStatement();
            String insert;

            //INSERT REGION
            insert = "insert into regions (region)\n" +
                    "values ('"+loc.getRegion()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT COUNTRIES
            insert = "insert into countries (country, idRegion)\n" +
                    "values ('"+loc.getCountry()+"', "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT CITIES
            insert = "insert into cities (city, idCountry)\n" +
                    "values ('"+loc.getCity()+"', "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
        }
        catch(Exception e){

        }



    }

}