import at.ac.tuwien.dsg.mediator.EtcdControl;
import at.ac.tuwien.dsg.utilities.PerformanceMonitor;


/**
 * Created by jomis on 29/09/14.
 */
public class Evaluation {

    public static void main (String[] args) {

        PerformanceMonitor performanceMonitor = new PerformanceMonitor();


        System.out.println(performanceMonitor.getCpuUsage());
        System.out.println(performanceMonitor.getMemorySize());
        System.out.println(performanceMonitor.getFreeMemorySize());
        System.out.println(performanceMonitor.getFreeDiskSpace());

        EtcdControl test = new EtcdControl();


//        Github github = new RtGithub("e5548ec6e750cb020ab1e4706e38dc44c2b9cf99");
//        Iterable repos;
//        try {
//            repos = github.search().repos("services","","");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //4UqAmW16HTl4rJWOWwHAAFDrk

//        Soda2Consumer consumer = Soda2Consumer.newConsumer("https://sandbox.demo.socrata.com",
//                "testuser@gmail.com",
//                "OpenData",
//                "4UqAmW16HTl4rJWOWwHAAFDrk");

        //consumer.getHttpLowLevel().queryRaw()queryRaw


    }
}
