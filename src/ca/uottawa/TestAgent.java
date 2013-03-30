package ca.uottawa;
import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.environments.Environment;
import ch.idsia.benchmark.mario.engine.sprites.Mario;



public class TestAgent implements Agent{

	protected boolean action[] = new boolean[Environment.numberOfKeys];
	
	@Override
	public boolean[] getAction() {
		
		action[Mario.KEY_RIGHT] = true;
		action[Mario.KEY_SPEED] = true;
		if (action[Mario.KEY_JUMP] == true)
			action[Mario.KEY_JUMP] = false;
		else
			action[Mario.KEY_JUMP] = true;

		return action;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void giveIntermediateReward(float arg0) {
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public void integrateObservation(Environment arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setObservationDetails(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

}
