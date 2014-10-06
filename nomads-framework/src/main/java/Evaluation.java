import at.ac.tuwien.dsg.mediator.EtcdControl;
import at.ac.tuwien.dsg.utilities.PerformanceMonitor;

import static java.lang.Thread.sleep;


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
        System.out.println(performanceMonitor.getTotalDiskSpace());
        long freeSpace = performanceMonitor.getFreeDiskSpace();
        long totalSpace = performanceMonitor.getTotalDiskSpace();

        double percentage = (100/(double)totalSpace) * (double)freeSpace;

        System.out.println(percentage);
        EtcdControl test = new EtcdControl();

        System.out.println("Testing usage ");

        double cpuUsage = performanceMonitor.getCpuUsage();

        try {
            long delay = (cpuUsage*100 > 0.5) ? 10000 : 1000;
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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
