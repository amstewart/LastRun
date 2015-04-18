package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.*;
import model.entity.Entity;

public class Spell implements Assetable{
	private int manaDecrease = 4;
	private boolean canPerform = true;
	private String id;
	
	public Spell(String id) {
		setAssetID(id);
		
	}
	public void decrementMana(final Entity entity){
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
	@Override
	public String getAssetID() {
		return id;
	}
	@Override
	public void setAssetID(String id) {
		this.id=id;
		
	}

}
