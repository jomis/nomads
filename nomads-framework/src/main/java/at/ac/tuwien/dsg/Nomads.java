package at.ac.tuwien.dsg;

import at.ac.tuwien.dsg.mediator.NomadsController;
import at.ac.tuwien.dsg.model.Deployment;
import at.ac.tuwien.dsg.model.Utilisation;
import at.ac.tuwien.dsg.model.FastKeyValueStore;
import at.ac.tuwien.dsg.services.NomadsResourceServer;

import java.util.List;


/**
 * Created by jomis on 07/10/14.
 */
public class Nomads {

    public static void main(String[] args) {

//        EtcdControl etcdControl = new EtcdControl();
//        etcdControl.getAll();

        NomadsController.testMe();

//          NomadsResourceServer.startServer(args);
//        NomadsResourceServer server = new NomadsResourceServer();
//        server.startServer(args);
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        FastKeyValueStore store = new FastKeyValueStore();
//        List<Utilisation> utilisations = store.getUtilisationByMetric("01");
//        System.out.println("Something");
//        for(Utilisation utilisation : utilisations){
//            System.out.println(utilisation);
//        }
//        store.keyDump();
//        System.out.println(store.getUtilisationByKey("258"));
//
//        Deployment deployment = new Deployment("hall","hall","hall","hall");
//
//        store.storeDeployment(deployment);
//        System.out.println("Deployment");
//        System.out.println(store.getDeploymentByHost("hall"));
    }

}
