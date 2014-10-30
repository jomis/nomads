package at.ac.tuwien.dsg.model;

import java.io.Serializable;

/**
 * Created by jomis on 30/10/14.
 */
public class Deployment implements Serializable {

    private static final long serialVersionUID = -4421252970661193623L;

    private final String host;
    private final String containerId;
    private final String serviceId;
    private final String type;

    public Deployment (String host, String containerId, String serviceId, String type) {

        this.host = host;
        this.containerId=containerId;
        this.serviceId=serviceId;
        this.type=type;

    }

    @Override
    public String toString() {
        return "Deployment [host=" + host +", containerId=" + containerId + ", serviceId="+ serviceId + ", type=" + type +"]";

    }

    public String getHost() {
        return host;
    }

    public String getContainerId() {
        return containerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getType() {
        return type;
    }
}
