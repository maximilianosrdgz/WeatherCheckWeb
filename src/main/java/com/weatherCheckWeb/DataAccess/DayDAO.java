package com.weatherCheckWeb.DataAccess;

import com.weatherCheckWeb.DBConfig.MySQLConnection;
import com.weatherCheckWeb.Domain.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
@Repository
public class DayDAO {

    @Autowired
    MySQLConnection mySQLCon;

    public void save(Day d, int recordCount){

        Statement stmtInsert;

        try{

            //INSERT DESCRIPTIONS
            stmtInsert = mySQLCon.getCon().createStatement();
            String insert;

            insert = "insert into Descriptions (description)\n" +
                    "values ('"+d.getDescription()+"')";
            stmtInsert.executeUpdate(insert);

            //INSERT WEEKDAYS
            insert = "insert into WeekDays (weekDay)\n" +
                    "values ('"+d.getDay()+"')";
            stmtInsert.executeUpdate(insert);

            //INSERT DAYS
            insert = "insert into Days (date, idWeekDay, maxTemp, minTemp, idDescription)\n" +
                    "values ('"+d.getDate()+"', "+recordCount+", "+d.getMaxTemp()+
                    ", "+d.getMinTemp()+", "+recordCount+")";
            stmtInsert.executeUpdate(insert);

            stmtInsert.close();
        }
        catch(Exception e){

        }
    }
}
