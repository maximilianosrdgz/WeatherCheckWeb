package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.Wind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class WindDAO {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Wind wind, int recordCount){

        //mySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{

            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            //INSERT WINDDATAS
            insert = "insert into WindDatas (speed, direction)\n" +
                    "values ("+wind.getSpeed()+", "+wind.getDirection()+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }

}
