package at.ac.tuwien.dsg.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by jomis on 30/10/14.
 */
public class Utilisation implements Serializable {

    private static final long serialVersionUID = -3321252970661193623L;
    private final String source;
    private final String group;
    private final String metric;
    private final double value;
    private final Timestamp timestamp;

    public Utilisation (String source, String group, String metric, double value, long millis) {
        this.source = source;
        this.group = group;
        this.metric = metric;
        this.value = value;
        this.timestamp = new Timestamp(millis);
    }

    @Override
    public String toString() {
        return "Utilisation [source=" + source +", group=" + group + ", metric="+ metric + ", value=" + value +"] received at:" +timestamp;

    }


    public String getSource() {
        return source;
    }

    public String getGroup() {
        return group;
    }

    public String getMetric() {
        return metric;
    }

    public double getValue() {
        return value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
