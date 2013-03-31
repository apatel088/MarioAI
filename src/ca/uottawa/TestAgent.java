package ca.uottawa;
import java.util.Arrays;
import java.util.List;

import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.environments.Environment;
import ch.idsia.benchmark.mario.engine.sprites.Mario;




public class TestAgent implements Agent{

	protected boolean action[] = new boolean[Environment.numberOfKeys];
	private boolean isMarioOnGround;
	private boolean isMarioAbleToJump;
	private boolean obsAhead;
	private boolean enemyAhead;
	
	
	public void jump(){
		if (isMarioAbleToJump || (!isMarioOnGround && action[Mario.KEY_JUMP]))
        {
            action[Mario.KEY_JUMP] = true;
        }
		else 
			action[Mario.KEY_JUMP] = false;
		
	}
	
	
	@Override
	public boolean[] getAction() {
		
		action[Mario.KEY_RIGHT] = true;
		action[Mario.KEY_SPEED] = true;
		
		if(this.obsAhead || this.enemyAhead)
			jump();
		

			
		
		//System.out.println(this.isOnGround);
		
		
		
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
	public void integrateObservation(Environment env) {
		// TODO Auto-generated method stub
		byte[][] en = env.getMergedObservationZZ(0, 0);
		//System.out.println(en.length + ", " + en[0].length);
		//System.out.println()
		for (int i=0; i<en.length; i++){
			for (int j=0; j<en[i].length; j++)
				System.out.print(en[i][j] + "\t");
			
			System.out.println();
		}
		this.isMarioOnGround = env.isMarioOnGround();
		this.isMarioAbleToJump = env.isMarioAbleToJump();
		//this.MarioPos = env.getMarioEgoPos();
		
		
			
		//obstacle ahead 
		//obsAhead = false;
		obsAhead = (en[10][9] < -100) || (en[9][10] == 9) || (en[9][10] < 0);
		enemyAhead = (en[9][11] > 20);
		
		
		System.out.println(this.obsAhead);
		System.out.println(en[10][9] + ", " + en[9][10]);
		System.out.println(env.getMarioEgoPos()[0] + ", "+ env.getMarioEgoPos()[1]);
		System.out.println(env.getMarioFloatPos()[0] + "," + env.getMarioFloatPos()[1]);
		
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
