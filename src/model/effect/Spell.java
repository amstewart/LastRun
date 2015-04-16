package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.Asset;
import model.entity.Entity;

public class Spell extends Asset{
	private int manaDecrease = 4;
	private boolean canPerform = true;
	public Spell(String id) {
		super(id);
		
	}
	public void decrementMana(Entity entity){
		entity.setMana(-manaDecrease);
		TimerTask timertask = new TimerTask(){
			@Override
			public void run() {
				entity.setMana(manaDecrease);	
			}		
		};
		Timer timer = new Timer();
		timer.schedule(timertask, 10000);	
	}
	
	public boolean canPerform(){
		return canPerform;
	}
	public void setCanPerform(int mana) {
		if(mana > manaDecrease){
			canPerform = true;
		}
		canPerform = false;	
	}

}
