package com.weatherCheckWeb.DBConfig;

import org.springframework.stereotype.Component;

import static com.weatherCheckWeb.DBConfig.Initialize.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MaxPower on 02/10/2016.
 */
@Component
public class MySQLConnection {

    private Connection con;

    private MySQLConnection() {

        try {

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getCon() {
        return con;
    }
}
