package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.Day;
import com.weatherCheckWeb.Domain.ExtendedForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
@Repository
public class ExtendedForecastDAO {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(ExtendedForecast extFore, int recordCount){

        Statement stmtInsert;
        String insert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();

            //INSERT EXTENDEDFORECASTS

            for(int i=0; i<10; i++){

                Day d = (Day)extFore.getExtForecast().get(i);
                insert = "insert into ExtendedForecasts(idForecast, date, weekDay, maxTemp, minTemp, description)\n" +
                        "values("+recordCount+", '"+d.getDate()+"', '"+d.getDay()+"', "+d.getMaxTemp()+", "+
                        d.getMinTemp()+", '"+d.getDescription()+"')";
                stmtInsert.executeUpdate(insert);

            }

            stmtInsert.close();
            //mySQLCon.getCon().close();
        }
        catch(Exception e){

        }
    }

}
