package at.ac.tuwien.dsg.mediator;

import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.responses.EtcdException;
import mousio.etcd4j.responses.EtcdKeysResponse;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by jomis on 03/10/14.
 */
public class EtcdControl {


    private EtcdClient etcd;

    public EtcdControl () {
        etcd = new EtcdClient();
    }

    public void getAll() {
        try {
            EtcdKeysResponse etcdKeysResponse = etcd.getAll().recursive().send().get();
            System.out.println(etcdKeysResponse.node.value);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (EtcdException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
