package com.example;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.responses.EtcdException;
import mousio.etcd4j.responses.EtcdKeysResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.sleep;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("computingresource/{dataendpoint}")
public class ComputingResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)

    public String computeIt(@PathParam("dataendpoint") String dataendpoint) {


        // Get the Proxy from etcd

        EtcdClient etcd = new EtcdClient();

        EtcdKeysResponse etcdKeysResponse = null;
        try {
            etcdKeysResponse  = etcd.get("/services/nomads/endpoint").send().get();

//            Properties systemProperties = System.getProperties();
//            systemProperties.setProperty("http.proxyHost",proxy);
//            systemProperties.setProperty("http.proxyPort",port);
//            etcdKeysResponse = etcd.getAll().recursive().send().get();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (EtcdException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(etcdKeysResponse.node.value);


        //Connect to data service

        Client client = Client.create();


        // Proxy everything via Jersey

        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 3128));

        // Proxy everthing that originates in the VM Context

        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "1234");

        WebResource webResource = client.resource("http://"+dataendpoint+"/application/webapi/dataresource/");

        ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);

        String output = response.getEntity(String.class);

        if (response.getStatus() != 200) {

            output = "ERROR:"+response.getStatus();

        }

        //Compute something based on utilization aka delay it

        PerformanceMonitor monitor = new PerformanceMonitor();

        double cpuUsage = monitor.getCpuUsage();

        try {
            long delay = (cpuUsage * 100 > 0.5) ? 10000 : 1000;
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "Computation finished:"+output;
    }
}
