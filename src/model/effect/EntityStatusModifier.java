package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.entity.Entity;
import model.entity.Status;
import model.map.LocalArea;

public class EntityStatusModifier extends Spell implements SpellEffect{
	private int baseLength;
	private int length;
	Status changeTo;
	public EntityStatusModifier(String id,Status changeTo) {
		super(id);
		this.changeTo = changeTo;
	}

	@Override
	public void applyMultiplier(int m) {
		length = baseLength * m;
		
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		if(canPerform()){
			final Entity affectedEntity = map.getEntityLinear();
			affectedEntity.addStatus(changeTo);
			TimerTask timertask = new TimerTask(){
				@Override
				public void run() {
					affectedEntity.removeStatus(changeTo);	
				}		
			};
			Timer timer = new Timer();
			timer.schedule(timertask, length * 1000);	
		}
	}
	
	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

}
