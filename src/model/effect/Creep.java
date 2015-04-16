package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.entity.Entity;
import model.entity.Status;

public class Creep implements InternalEffect{
	
	private int movementDecrease = 10;
	private int baseLength = 2;
	private int length;
	
	@Override
	public void applyMultiplier(int m) {
		this.length = baseLength * m;
	}

	@Override
	public void applyEffect(Entity entity) {
		entity.addStatus(Status.INVISIBLE);
		entity.setMovement(-movementDecrease);
		TimerTask timertask = new TimerTask(){
			@Override
			public void run() {
				entity.removeStatus(Status.INVISIBLE);	
				entity.setMovement(movementDecrease);
			}		
		};
		Timer timer = new Timer();
		timer.schedule(timertask, length * 1000);	
	}

}
