package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestApi {
    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)   // The response will be returned as plain text
    public Response getListUE() {
        // Build an HTTP 200 (OK) response with the message "Hello World!"
        return Response
                .status(200)                  // HTTP status code 200 = success
                .entity(helper.getListeUE())       // The body of the response
                .build();                     // Builds the final Response object
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)// The response will be returned as plain text
    public Response addUE(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response.status(201).entity("Created").build();
        } else {
            return Response.status(400).entity("Error").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")                          // {name} is a dynamic variable in the URL
    public Response getUEByCode(@PathParam("code") int code) {
        // Build a personalized response message using the provided name
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }
}
