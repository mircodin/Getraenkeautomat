package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("getraenk")
public class GetraenkService {
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGetraenke() {
        List<Getraenk> getraenkList = DataHandler.getInstance().readAllGetraenke();
        Response response = Response
                .status(200)
                .entity(getraenkList)
                .build();
        return response;
    }
}
