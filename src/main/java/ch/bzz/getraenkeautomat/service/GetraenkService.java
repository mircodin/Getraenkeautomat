package ch.bzz.getraenkeautomat.service;

import ch.bzz.getraenkeautomat.data.DataHandler;
import ch.bzz.getraenkeautomat.model.Getraenk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("getraenk")
public class GetraenkService {
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBooks() {
        List<Getraenk> bookList = DataHandler.getInstance().readAllBooks();
        Response response = Response
                .status(200)
                .entity(bookMap)
                .build();
        return response;
    }
}
