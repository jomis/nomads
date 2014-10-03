package at.ac.tuwien.dsg.mediator;

import mousio.etcd4j.EtcdClient;

import java.io.IOException;

/**
 * Created by jomis on 03/10/14.
 */
public class EtcdControl {


    private EtcdClient etcd;

    public EtcdControl () {
       etcd = new EtcdClient();

    }
}
