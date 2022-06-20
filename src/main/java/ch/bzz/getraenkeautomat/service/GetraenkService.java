package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        List<Getraenk> getraenkList = DataHandler.readAllGetraenke();
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
        Getraenk getraenk = DataHandler.readGetraenkByUUID(getraenkUUID);
        return Response
                .status(200)
                .entity(getraenk)
                .build();
    }

    /**
     * inserts a new Getraenk
     * @param bezeichnung
     * @param preis
     * @param inhaltInML
     * @param ablaufdatum
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertGetraenk(
            @FormParam("bezeichnung") String bezeichnung,
            @FormParam("preis") Double preis,
            @FormParam("inhaltInML") Integer inhaltInML,
            @FormParam("ablaufdatum") Date ablaufdatum,
            @FormParam("getraenkeautomatUUID") String getraenkeautomatUUID,
            @FormParam("markeUUID") String markeUUID
    ) {
        Getraenk getraenk = new Getraenk();
        getraenk.setGetraenkUUID(UUID.randomUUID().toString());
        getraenk.setBezeichnung(bezeichnung);
        getraenk.setPreis(preis);
        getraenk.setGetraenkeautomatUUID(getraenkeautomatUUID);
        getraenk.setMarkeUUID(markeUUID);

        DataHandler.insertGetraenk(getraenk);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * deletes a Getraenk identified by its uuid
     * @param getraenkUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteGetraenk(
            @QueryParam("uuid") String getraenkUUID
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteGetraenk(getraenkUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * updates a Getraenk
     * @param getraenkUUID
     * @param bezeichnung
     * @param preis
     * @param inhaltInML
     * @param ablaufdatum
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateGetraenk(
            @FormParam("getraenkUUID") String getraenkUUID,
            @FormParam("bezeichnung") String bezeichnung,
            @FormParam("preis") Double preis,
            @FormParam("inhaltInML") Integer inhaltInML,
            @FormParam("ablaufdatum") Date ablaufdatum,
            @FormParam("getraenkeautomatUUID") String getraenkeautomatUUID,
            @FormParam("markeUUID") String markeUUID
    ) {
        int httpStatus = 200;
        Getraenk getraenk = DataHandler.readGetraenkByUUID(getraenkUUID);
        if (getraenk != null) {
            getraenk.setBezeichnung(bezeichnung);
            getraenk.setPreis(preis);
            getraenk.setGetraenkeautomatUUID(getraenkeautomatUUID);
            getraenk.setMarkeUUID(markeUUID);
            DataHandler.updateGetraenk();
        } else {
            httpStatus = 410;
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
