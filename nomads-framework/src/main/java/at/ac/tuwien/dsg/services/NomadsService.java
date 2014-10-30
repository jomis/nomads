package at.ac.tuwien.dsg.services;

import at.ac.tuwien.dsg.model.Utilisation;
import at.ac.tuwien.dsg.model.FastKeyValueStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;


@Path("nomadsservice")
public class NomadsService {


    private static FastKeyValueStore store = new FastKeyValueStore();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String computeIt() {

        //Compute something based on utilization aka delay it


        return "Computation finished";
    }
}
