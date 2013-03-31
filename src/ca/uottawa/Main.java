package ca.uottawa;
import ch.idsia.agents.controllers.ForwardAgent;
import ch.idsia.agents.controllers.ScaredAgent;
import ch.idsia.agents.controllers.human.HumanKeyboardAgent;

import ch.idsia.benchmark.tasks.BasicTask;
import ch.idsia.tools.MarioAIOptions;

public class Main {

    public static void main(String[] args) {
      TestAgent agent = new TestAgent();
      //HumanKeyboardAgent agent = new HumanKeyboardAgent();

      MarioAIOptions options= new MarioAIOptions();

      options.setLevelDifficulty(0);
      options.setLevelRandSeed(43);
      options.setFrozenCreatures(false);
      //options.setFlatLevel(true);
      options.setLevelType(0);
      options.setAgent(agent);

      BasicTask task = new BasicTask(options);
      task.runSingleEpisode(1);
    }
}
