package model.effect;

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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

}
