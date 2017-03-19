package com.nnbee.ws.contractor;

import javax.inject.Named;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by lzylz on 2017/3/19.
 */
@Named
@Path("/test")
@WebService
public class TestContractor {

    @Path("get")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response test(@QueryParam("param") String msg){
        String result = "Restful example : " + msg;

        return Response.status(200).entity(result).build();
    }
}
