package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("getraenk")
public class GetraenkService {
    /**
     * reads a list of all getraenke
     * @return getraenke as JSON
     */
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
    /**
     * reads one specific getraenk
     * @param getraenkUUID
     * @return getraenk as JSON
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readGetraenk(
            @QueryParam("uuid") String getraenkUUID
    ) {
        Getraenk getraenk = DataHandler.getInstance().readGetraenkByUUID(getraenkUUID);
        return Response
                .status(200)
                .entity(getraenk)
                .build();
    }
}
