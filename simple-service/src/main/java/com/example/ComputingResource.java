package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.lang.Thread.sleep;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("computingresource")
public class ComputingResource {

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

        PerformanceMonitor monitor = new PerformanceMonitor();

        double cpuUsage = monitor.getCpuUsage();

        try {
            long delay = (cpuUsage*100 > 0.5) ? 10000 : 1000;
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "Computation finished";
    }
}
