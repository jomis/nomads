package at.ac.tuwien.dsg.mediator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.MessageFormat;

/**
 * Created by jomis on 30/10/14.
 */
public class NomadsController {

    // Remote String /opt/fleet-v0.8.3-linux-amd64/
    //private static String fleetctl = "/bin/bash -l -c `/usr/local/bin/fleetctl --endpoint http://172.17.42.1:4001 {0}`";
    private static String fleetctl = "/usr/local/bin/fleetctl --tunnel 128.130.172.190 {0}";
    private static String xfleetStub = "\n"
                                     + "[X-Fleet]\n"
                                     + "MachineMetadata={0}";


    public static void testMe() {

        String command = MessageFormat.format(fleetctl,"list-machines");
        System.out.println("Executing: "+command);
        System.out.println(executeCommand(command));
    }

    public static String getServiceUnitDescription(String serviceUnitName) {

        String substitution = "cat " + serviceUnitName;

        String command = MessageFormat.format(fleetctl,substitution);
        return executeCommand(command);

    }


    private static boolean writeServiceUnitFile (String content, String serviceUnitNameWithExtension) {

        try {
            PrintWriter out = new PrintWriter(serviceUnitNameWithExtension);
            out.write(content);
            out.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
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
