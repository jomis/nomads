package com.example;

import org.apache.commons.lang3.RandomStringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("dataresource")
public class DataResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getData() {

        // Return variable amount based on disksize very basic version
        PerformanceMonitor monitor = new PerformanceMonitor();

        long freeSpace = monitor.getFreeDiskSpace();
        long totalSpace = monitor.getTotalDiskSpace();

        double percentage = (100/(double)totalSpace) * (double)freeSpace;

        int variableReturn = percentage > 50 ? 100 : 1000;
        return RandomStringUtils.random(variableReturn);
    }
}
