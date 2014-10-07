package at.ac.tuwien.dsg.optimizer;

import org.opt4j.core.problem.ProblemModule;

/**
 * Created by jomis on 07/10/14.
 */
public class NomadsModule extends ProblemModule {
    @Override
    protected void config() {
        //bindProblem(NomadsCreator.class, NomadsDecoder.class, NomadsEvaluator.class);
    }
}
