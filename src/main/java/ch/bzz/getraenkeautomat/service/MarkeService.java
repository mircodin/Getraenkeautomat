package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Marke;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("marke")
public class MarkeService {
    /**
     * reads a list of all marken
     * @return marken as JSON
     */
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMarke() {
        List<Marke> markeList = DataHandler.readAllMarken();
        Response response = Response
                .status(200)
                .entity(markeList)
                .build();
        return response;
    }
    /**
     * reads one specific marke
     * @param markeUUID
     * @return marke as JSON
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMarke(
            @QueryParam("uuid") String markeUUID
    ) {
        Marke marke = DataHandler.readMarkeByUUID(markeUUID);
        return Response
                .status(200)
                .entity(marke)
                .build();
    }
}