package at.ac.tuwien.dsg.services;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.net.URI;
import java.text.MessageFormat;

/**
 * Created by jomis on 29/10/14.
 */
public class NomadsResourceServer {


    private static String BASE_URI_TEMPLATE = "http://{0}:9898";

    private static boolean persistentMonitoring = false;

    private static String BASE_URI;

    private static HttpServer httpServer;


    public static void startServer(String[] argv) {


        // Create the correct URIs

        BASE_URI = MessageFormat.format(BASE_URI_TEMPLATE, argv);

        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("at.ac.tuwien.dsg.services");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        new Thread(
                () -> {
                    try {
                        httpServer.start();
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

        ).start();
    }

}
