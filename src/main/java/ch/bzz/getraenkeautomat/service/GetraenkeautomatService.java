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
        return Response
                .status(200)
                .entity(getraenkeautomatList)
                .build();
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
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertGetraenkeautomat(
            @Valid @BeanParam Getraenkeautomat getraenkeautomat
    ) {
        getraenkeautomat.setGetraenkeautomatUUID(UUID.randomUUID().toString());

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
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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

    /**
     * updates a Getraenkeautomat
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateGetraenkeautomat(
            @Valid @BeanParam Getraenkeautomat getraenkeautomat
    ) {
        int httpStatus = 200;
        Getraenkeautomat oldGetraenkeautomat = DataHandler.readGetraenkeautomatbyUUID(getraenkeautomat.getGetraenkeautomatUUID());
        if (oldGetraenkeautomat != null) {
            oldGetraenkeautomat.setModellnummer(getraenkeautomat.getModellnummer());
            oldGetraenkeautomat.setFarbe(getraenkeautomat.getFarbe());
            DataHandler.updateGetraenkeautomat();
        } else {
            httpStatus = 410;
        }

        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
