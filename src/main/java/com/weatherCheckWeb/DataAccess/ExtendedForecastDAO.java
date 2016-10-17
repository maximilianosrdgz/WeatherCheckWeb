package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.ExtendedForecast;
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
public class ExtendedForecastDAO {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(ExtendedForecast extFore, int recordCount){

        //mySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            //INSERT EXTENDEDFORECASTS
            insert = "insert into ExtendedForecasts (idForecast, idDay)\n" +
                    "values ("+recordCount+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }

}
