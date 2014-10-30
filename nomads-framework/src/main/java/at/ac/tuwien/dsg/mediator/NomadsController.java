package at.ac.tuwien.dsg.mediator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jomis on 30/10/14.
 */
public class NomadsController {


    public static void testMe() {

        String command = "/opt/fleet-v0.8.3-linux-amd64/fleetctl --endpoint http://172.17.42.1:4001 list-machines";

        System.out.println(executeCommand(command));
    }

    public static String getServiceUnitDescription() {

        return null;
    }

    public static boolean transferServiceUnit() {

        return true;
    }

    private static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

}
