package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;
import ch.bzz.getraenkeautomat.model.Marke;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

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
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertMarke(
            @Valid @BeanParam Marke marke
    ) {
        marke.setMarkeUUID(UUID.randomUUID().toString());

        DataHandler.insertMarke(marke);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * deletes a marke identified by its uuid
     * @param markeUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMarke(
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMarke(
            @Valid @BeanParam Marke marke
    ) {
        int httpStatus = 200;
        Marke oldMarke = DataHandler.readMarkeByUUID(marke.getMarkeUUID());
        if (oldMarke != null) {
            oldMarke.setBezeichnung(marke.getBezeichnung());
            oldMarke.setHauptsitz(marke.getHauptsitz());
            oldMarke.setUmsatz(marke.getUmsatz());
            oldMarke.setTelefonnummer(marke.getTelefonnummer());
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