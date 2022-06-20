package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;
import ch.bzz.getraenkeautomat.model.Marke;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;
import java.util.UUID;

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

    /**
     * inserts a new Marke
     * @param bezeichnung
     * @param hauptsitz
     * @param umsatz
     * @param telefonnummer
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertMarke(
            @FormParam("bezeichnung") String bezeichnung,
            @FormParam("hauptsitz") String hauptsitz,
            @FormParam("umsatz") Integer umsatz,
            @FormParam("telefonnummer") String telefonnummer
    ) {
        Marke marke = new Marke();
        marke.setMarkeUUID(UUID.randomUUID().toString());
        marke.setBezeichnung(bezeichnung);
        marke.setHauptsitz(hauptsitz);
        marke.setUmsatz(umsatz);
        marke.setTelefonnummer(telefonnummer);

        DataHandler.insertMarke(marke);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * deletes a song identified by its uuid
     * @param markeUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMarke(
            @QueryParam("uuid") String markeUUID
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteMarke(markeUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * updates a Marke
     * @param markeUUID
     * @param bezeichnung
     * @param hauptsitz
     * @param umsatz
     * @param telefonnummer
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMarke(
            @FormParam("markeUUID") String markeUUID,
            @FormParam("bezeichnung") String bezeichnung,
            @FormParam("hauptsitz") String hauptsitz,
            @FormParam("umsatz") Integer umsatz,
            @FormParam("telefonnummer") String telefonnummer
    ) {
        int httpStatus = 200;
        Marke marke = DataHandler.readMarkeByUUID(markeUUID);
        if (markeUUID != null) {
            marke.setBezeichnung(bezeichnung);
            marke.setHauptsitz(hauptsitz);
            marke.setUmsatz(umsatz);
            marke.setTelefonnummer(telefonnummer);
            DataHandler.updateMarke();
        } else {
            httpStatus = 410;
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}