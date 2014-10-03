package at.ac.tuwien.dsg.utilities;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * Created by jomis on 01/10/14.
 * Adapted from http://stackoverflow.com/questions/25552/get-os-level-system-information
 * http://stackoverflow.com/questions/5512378/how-to-get-ram-size-and-size-of-hard-disk-using-java
 * <p/>
 * Provides a basic not absolutely accurate but close enough performance monitor for a system
 */
public class PerformanceMonitor {
    private int availableProcessors = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
    private long lastSystemTime = 0;
    private long lastProcessCpuTime = 0;


    public synchronized long getMemorySize() {

        return ((OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
    }

    public synchronized long getFreeMemorySize() {

        return ((OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean()).getFreePhysicalMemorySize();
    }

    public synchronized long getTotalDiskSpace() {

        File disk = new File("/");
        return disk.getTotalSpace() / (1024 * 1024);
    }

    public synchronized long getFreeDiskSpace() {
        File disk = new File("/");
        return disk.getFreeSpace() / (1024 * 1024);
    }

    public synchronized double getCpuUsage() {
        if (lastSystemTime == 0) {
            baselineCounters();

        }

        long systemTime = System.nanoTime();
        long processCpuTime = 0;

        if (ManagementFactory.getOperatingSystemMXBean() instanceof OperatingSystemMXBean) {
            processCpuTime = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getProcessCpuTime();
        }

        double cpuUsage = (double) (processCpuTime - lastProcessCpuTime) / (systemTime - lastSystemTime);

        lastSystemTime = systemTime;
        lastProcessCpuTime = processCpuTime;

        return cpuUsage / availableProcessors;
    }

    private void baselineCounters() {
        lastSystemTime = System.nanoTime();

        if (ManagementFactory.getOperatingSystemMXBean() instanceof OperatingSystemMXBean) {
            lastProcessCpuTime = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getProcessCpuTime();
        }
    }


}
