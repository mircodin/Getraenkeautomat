package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;
import java.util.UUID;

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
        List<Getraenkeautomat> getraenkeautomatList = DataHandler.readAllGetraenkeautomaten();
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
        Getraenkeautomat getraenkeautomat = DataHandler.readGetraenkeautomatbyUUID(getraenkeautomatUUID);
        return Response
                .status(200)
                .entity(getraenkeautomat)
                .build();
    }

    /**
     * inserts a new Getraenkeautomat
     * @param modellnummer
     * @param farbe
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertGetraenkeautomat(
            @FormParam("modellnummer") String modellnummer,
            @FormParam("farbe") String farbe
    ) {
        Getraenkeautomat getraenkeautomat = new Getraenkeautomat();
        getraenkeautomat.setGetraenkeautomatUUID(UUID.randomUUID().toString());
        getraenkeautomat.setModellnummer(modellnummer);
        getraenkeautomat.setFarbe(farbe);

        DataHandler.insertGetraenkeautomat(getraenkeautomat);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * deletes a Getraenkeautomat identified by its uuid
     * @param getraenkeautomatUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteGetraenkeautomat(
            @QueryParam("uuid") String getraenkeautomatUUID
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteGetraenkeautomat(getraenkeautomatUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
