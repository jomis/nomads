package at.ac.tuwien.dsg;

import at.ac.tuwien.dsg.mediator.EtcdControl;

/**
 * Created by jomis on 07/10/14.
 */
public class Nomads {

    public static void main(String[] args) {

        EtcdControl etcdControl = new EtcdControl();
        etcdControl.getAll();

    }
}
