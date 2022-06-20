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
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertGetraenk(
            @Valid @BeanParam Getraenk getraenk,
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("getraenkeautomatUUID") String getraenkeautomatUUID,
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("markeUUID") String markeUUID
    ) {
        getraenk.setGetraenkUUID(UUID.randomUUID().toString());
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
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
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
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateGetraenk(
            @Valid @BeanParam Getraenk getraenk,
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("getraenkeautomatUUID") String getraenkeautomatUUID,
            @NotEmpty
            @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("markeUUID") String markeUUID
    ) {
        int httpStatus = 200;
        Getraenk oldGetraenk = DataHandler.readGetraenkByUUID(getraenk.getGetraenkUUID());
        if (oldGetraenk != null) {
            oldGetraenk.setBezeichnung(getraenk.getBezeichnung());
            oldGetraenk.setPreis(getraenk.getPreis());
            oldGetraenk.setGetraenkeautomatUUID(getraenkeautomatUUID);
            oldGetraenk.setMarkeUUID(markeUUID);
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
