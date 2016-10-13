package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class DayDAO {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Day d, int recordCount){

        //mySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{

            //INSERT DESCRIPTIONS
            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            insert = "insert into Descriptions (description)\n" +
                    "values ('"+d.getDescription()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT WEEKDAYS
            insert = "insert into WeekDays (weekDay)\n" +
                    "values ('"+d.getDay().toString()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT DAYS
            insert = "insert into Days (date, idWeekDay, maxTemp, minTemp, idDescription)\n" +
                    "values ('2016/01/01', "+recordCount+", "+d.getMaxTemp()+
                    ", "+d.getMinTemp()+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }
}
