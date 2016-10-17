package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.Atmosphere;
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
public class AtmosphereDAO {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Atmosphere atmos, int recordCount){

        //mySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            //INSERT ATMOSPHERICDATAS
            insert = "insert into AtmosphericDatas (humidity, preasure, visibility)\n" +
                    "values ("+atmos.getHumidity()+", "+atmos.getPressure()+
                    ", "+atmos.getVisibility()+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }

}
