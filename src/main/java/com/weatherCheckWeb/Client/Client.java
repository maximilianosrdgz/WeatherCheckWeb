package com.weatherCheckWeb.Client;

import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by MaxPower on 15/10/2016.
 */
@Component
public interface Client {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    Response someMethod(@QueryParam(value = "someQueryParamHere") String query);

}