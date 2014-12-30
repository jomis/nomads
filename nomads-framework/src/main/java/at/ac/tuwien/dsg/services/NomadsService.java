package at.ac.tuwien.dsg.services;

import at.ac.tuwien.dsg.model.Utilisation;
import at.ac.tuwien.dsg.model.FastKeyValueStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;


@Path("nomadsservice")
public class NomadsService {


    private static FastKeyValueStore store = new FastKeyValueStore();

    /**
     * Request proxy for all service calls in the Environment
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response forwardRequest() {

        //Compute something based on utilization aka delay it


        return "Computation finished";
    }
}
