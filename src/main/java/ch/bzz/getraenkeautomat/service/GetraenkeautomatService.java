package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("getraenkeautomat")
public class GetraenkeautomatService {
    /**
     * reads a list of all getraenkeautomaten
     * @return getraenkeautomaten as JSON
     */
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGetraenkeautomat() {
        List<Getraenkeautomat> getraenkeautomatList = DataHandler.getInstance().readAllGetraenkeautomaten();
        Response response = Response
                .status(200)
                .entity(getraenkeautomatList)
                .build();
        return response;
    }
    /**
     * reads one specific getraenkeautomat
     * @param getraenkeautomatUUID
     * @return getraenkeautomat as JSON
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readGetraenkeautomat(
            @QueryParam("uuid") String getraenkeautomatUUID
    ) {
        Getraenkeautomat getraenkeautomat = DataHandler.getInstance().readGetraenkeautomatbyUUID(getraenkeautomatUUID);
        return Response
                .status(200)
                .entity(getraenkeautomat)
                .build();
    }
}
