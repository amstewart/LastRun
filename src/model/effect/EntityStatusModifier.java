package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.entity.Entity;
import model.entity.Status;
import model.map.GameMap;
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
	public void applyEffect(GameMap map, Entity entity, int radius) {
		if(canPerform()){
			
		}
	}
	
	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

}
