package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Marke;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("marke")
public class MarkeService {
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMarke() {
        List<Marke> markeList = DataHandler.getInstance().readAllMarken();
        Response response = Response
                .status(200)
                .entity(markeList)
                .build();
        return response;
    }
}