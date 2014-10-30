package at.ac.tuwien.dsg.services;

import at.ac.tuwien.dsg.model.Utilisation;
import at.ac.tuwien.dsg.model.FastKeyValueStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;


@Path("monitoringservice")
public class MonitoringService {


    private static FastKeyValueStore store = new FastKeyValueStore();

    @POST
    public void newUtilisation(String utilisationValues) {

        String[] utilisations = utilisationValues.split("\\r?\\n");

        System.out.println("Found:" + utilisations.length);


        // Diamond default looks like
        // systems.<hostname>.<metrics>.<metric>
        String regularExpression = "((.+)\\.loadavg\\.(.+))";

        Pattern pattern = Pattern.compile(regularExpression);

        for (String entry : utilisations) {

            Matcher matcher = pattern.matcher(entry);

            if (matcher.matches()) {
                //System.out.println(entry);
                String[] parts = entry.split(" ");
                String[] metrics = parts[0].split("\\.");


                Utilisation utilisation = new Utilisation(metrics[1], metrics[2], metrics[3], Double.parseDouble(parts[1]), Long.parseLong(parts[2]));

                if (store.storeUtilisation(utilisation))
                    System.out.println("Stored:" + utilisation);
                else
                    System.out.println("Problem storing:" + utilisation);


            }


        }

    }
}
