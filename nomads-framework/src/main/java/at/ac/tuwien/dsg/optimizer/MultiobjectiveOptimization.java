package at.ac.tuwien.dsg.optimizer;

import org.opt4j.benchmarks.dtlz.DTLZModule;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.start.Opt4JTask;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithmModule;
import org.opt4j.viewer.ViewerModule;

/**
 * Created by jomis on 06/10/14.
 */
public class MultiobjectiveOptimization {

    public void optimize() {
        EvolutionaryAlgorithmModule ea = new EvolutionaryAlgorithmModule();
        ea.setGenerations(500);
        ea.setAlpha(100);
        DTLZModule dtlz = new DTLZModule();
        dtlz.setFunction(DTLZModule.Function.DTLZ1);
        ViewerModule viewer = new ViewerModule();
        viewer.setCloseOnStop(false);
        //TODO Set to correct Problem
        Runnable optimizationTask = () -> {
            Opt4JTask task = new Opt4JTask(false);
            task.init(ea, dtlz, viewer);
            try {
                task.execute();
                Archive archive = task.getInstance(Archive.class);
                for (Individual individual : archive) {
                    // obtain the phenotype and objective, etc. of each individual
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                task.close();
            }
        };
        optimizationTask.run();
    }
}
