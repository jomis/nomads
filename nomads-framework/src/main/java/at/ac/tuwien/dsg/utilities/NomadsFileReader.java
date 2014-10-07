package at.ac.tuwien.dsg.utilities;



import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * Created by jomis on 07/10/14.
 */
public class NomadsFileReader {

    public Map<String, String> readNomadsFile (String yamlAsString) {

        Yaml yaml = new Yaml();
        return  (Map<String, String>) yaml.load(yamlAsString);
    }


}
